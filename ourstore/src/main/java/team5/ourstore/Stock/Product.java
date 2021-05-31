package team5.ourstore.Stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

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

    @Column(name="brandname")
    String brandname;

    @Column(name = "categoryid")
    int categoryid;

    @Column(name="categoryname")
    String categoryname;
    
    @Column(name = "price")
    float price;
}
