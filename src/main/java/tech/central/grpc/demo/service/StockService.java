package tech.central.grpc.demo.service;

import io.grpc.stub.StreamObserver;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import tech.central.grpc.demo.constant.Constants;
import tech.central.grpc.demo.repository.StockItemRepository;
import tech.central.grpc.demo.stub.*;

@GRpcService
public class StockService extends StockItemInterfaceGrpc.StockItemInterfaceImplBase {

    Logger logger = LoggerFactory.getLogger(StockService.class);

    @Autowired
    private StockItemRepository stockItemRepository;

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void addStockItem(StockItem request, StreamObserver<ApiResponse> responseObserver) {
        tech.central.grpc.demo.model.StockItem stockItem = new tech.central.grpc.demo.model.StockItem();
        stockItem.setId(request.getId()).setSku(request.getSku()).setQuantity(request.getQty());
        stockItemRepository.save(stockItem);
        getResponse(responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void bulkAddStockItem(StockItemList request, StreamObserver<ApiResponse> responseObserver) {
        request.getStockItemList().forEach(requestStockItem -> {
            tech.central.grpc.demo.model.StockItem stockItem = new tech.central.grpc.demo.model.StockItem();
            stockItem.setId(requestStockItem.getId()).setSku(requestStockItem.getSku()).setQuantity(requestStockItem.getQty());
            stockItemRepository.save(stockItem);
        });
        getResponse(responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getStockItem(StockItemRequest request, StreamObserver<StockItem> responseObserver) {
        tech.central.grpc.demo.model.StockItem stockItem = stockItemRepository.findBySku(request.getSku());
        StockItem stockItem1 = StockItem.newBuilder().setId(stockItem.getId()).
                setSku(stockItem.getSku()).setQty(stockItem.getQuantity()).build();
        responseObserver.onNext(stockItem1);
        responseObserver.onCompleted();
    }

    private void getResponse(StreamObserver<ApiResponse> responseObserver) {
        ApiResponse response = ApiResponse.newBuilder().setResponseCode(200).
                setResponseMessage(Constants.STOCK_ITEM_SAVED).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        logger.info(Constants.STOCK_ITEM_SAVED);
    }
}
