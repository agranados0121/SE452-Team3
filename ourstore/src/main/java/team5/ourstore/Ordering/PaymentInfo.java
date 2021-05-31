package team5.ourstore.Ordering;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="paymentinfo")
@Document(collection = "paymentinfo")
public class PaymentInfo {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int paymentid;
	String firstname;
	String lastname;
	@Size(min=16, max=16, message = "Please enter a valid 16-digit credit card number")
	String cardnum;
	@Digits (integer = 3, fraction = 0, message = "Please enter a valid 3-digit security code")
	int securitynum;
	@Digits (integer = 5, fraction = 0, message = "Please enter a valid 5-digit zip code")
	int zip;
	String expdate;

	@Override
	public String toString() {
		return String.format("card number: %s", cardnum);
	}
}