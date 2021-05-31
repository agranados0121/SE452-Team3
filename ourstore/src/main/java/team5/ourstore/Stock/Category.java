package team5.ourstore.Stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Category {

    @Id
    @Column(name = "categoryid")
    int categoryid;

    @Column(name = "categoryname")
    String categoryname;
    
}
