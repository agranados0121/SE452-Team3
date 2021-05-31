package team5.ourstore.Ordering;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customerorder")
public class CustomerOrder {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    int orderid;
    
    @Column(name = "customerid")
    int customerid;

    @Column(name = "orderdate")//Format: YYYY-MM-DD
    String orderdate;
    
    @Column(name = "shipdate")//YYYY-MM-DD
    String shipdate;

}
