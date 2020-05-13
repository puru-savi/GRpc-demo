package tech.central.grpc.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.central.grpc.demo.model.StockItem;

@Repository
public interface StockItemRepository extends CrudRepository<StockItem, Long>
{
    StockItem findBySku(String sku);
}

