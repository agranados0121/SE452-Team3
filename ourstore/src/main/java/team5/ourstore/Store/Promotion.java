package team5.ourstore.Store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Promotion {
    @Id
    @Column(name = "promotion_id")
    int id;
    @Column(name = "product_id")
    int product_id;
    @Column(name = "active")
    Boolean active;
    @Column(name = "percent")
    float percent;
}