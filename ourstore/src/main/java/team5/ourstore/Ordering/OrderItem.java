package team5.ourstore.Ordering;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class OrderItem {

    @Id
    @Column(name = "orderid")
    int orderid;
    @Column(name = "productid")
    int productid;
    @Column(name = "quantity")
    int quantity;
    @Column(name = "price")
    float price;
    
}
