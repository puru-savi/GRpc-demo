package tech.central.grpc.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"sku"})
})
@Accessors(chain = true)
public class StockItem {

    @Id
    @Column
    protected long id;

    @Column
    String sku;

    @Column
    long quantity;
}

