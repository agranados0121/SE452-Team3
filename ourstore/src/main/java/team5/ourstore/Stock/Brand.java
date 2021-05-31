package team5.ourstore.Stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Brand {

    @Id
    @Column(name = "brandid")
    int brandid;

    @Column(name = "brandname")
    String brandname;
    
}
