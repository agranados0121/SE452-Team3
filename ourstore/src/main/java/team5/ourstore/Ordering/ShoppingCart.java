package team5.ourstore.Ordering;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team5.ourstore.Stock.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shoppingcart")
@Document(collection = "shoppingcart")
public class ShoppingCart {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartid;
	int customerid;
	int paymentid;
	int shippingid;
	List<Product> products = new ArrayList<Product>();
	float price;

	@Override
	public String toString() {
		return String.format("price: %s", price);
	}
}