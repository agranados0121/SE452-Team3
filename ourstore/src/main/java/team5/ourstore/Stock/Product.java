package team5.ourstore.Stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private long productid;

    @Column(name = "productname")
    String productname;

    @Column(name="brandid")
    int brandid;

    @Column(name = "categoryid")
    int categoryid;

    @Column(name = "price")
    float price;
}
