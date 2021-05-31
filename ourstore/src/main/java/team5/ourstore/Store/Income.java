package team5.ourstore.Store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Income {

    @Id
    @Column(name = "productid")
    int productid;
    @Column(name = "price")
    float price;
    
}
