package team5.ourstore.Stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
@Data

@Entity
public class Brands {
    @Id
    @Column(name = "brand_id")
    Integer id;
    @Column(name = "brand_name")
    String name;
}
