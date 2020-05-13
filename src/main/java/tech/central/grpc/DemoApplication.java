package tech.central.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tech.central.grpc.demo.service.StockService;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args){
            SpringApplication.run(DemoApplication.class, args);
        }
    }