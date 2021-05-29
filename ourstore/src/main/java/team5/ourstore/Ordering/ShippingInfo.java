package team5.ourstore.Ordering;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ShippingInfo")
@Document(collection = "ShippingInfo")
public class ShippingInfo {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int shipping_id;
	private String first_name;
	private String last_name;
	private String street_address;
	private String city;
	private String state;
	@Digits (integer = 5, fraction = 0, message = "Please enter a valid 5-digit zip code")
	private int zip;

	@Override
	public String toString() {
		return String.format("street address: %s, city: %s, state: %s", street_address, city, state);
	}
}