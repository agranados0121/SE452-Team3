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
@Table(name="shippinginfo")
@Document(collection = "shippinginfo")
public class ShippingInfo {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int shippingid;
	String firstname;
	String lastname;
	String streetaddress;
	String city;
	String state;
	@Digits (integer = 5, fraction = 0, message = "Please enter a valid 5-digit zip code")
	int zip;

	@Override
	public String toString() {
		return String.format("street address: %s, city: %s, state: %s", streetaddress, city, state);
	}
}