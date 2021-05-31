package team5.ourstore.Store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Promotion {

    @Id
    @Column(name = "promotionid")
    int promotionid;
    //@Column(name = "brandid")
    //int brandid;
    //@Column(name = "categoryid")
    //int categoryid;
    @Column(name = "productid")
    long productid;
    @Column(name = "active")
    Boolean active;
    @Column(name = "discount")
    float discount;
    @Column(name = "description")
    String description;

}
