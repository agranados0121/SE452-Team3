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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ShoppingCart")
@Document(collection = "ShoppingCart")
public class ShoppingCart {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cart_id;
	private int user_id;
	private int shipping_id;
	private int payment_id;
	private int promo_id;
	private List<Integer> products = new ArrayList<Integer>();
	private float price;

	@Override
	public String toString() {
		return String.format("price: %s", price);
	}
}