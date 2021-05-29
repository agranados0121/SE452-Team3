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
@Table(name="PaymentInfo")
@Document(collection = "PaymentInfo")
public class PaymentInfo {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int payment_id;
	private String first_name;
	private String last_name;
	@Size(min=16, max=16, message = "Please enter a valid 16-digit credit card number")
	private String card_number;
	@Digits (integer = 3, fraction = 0, message = "Please enter a valid 3-digit security code")
	private int security_num;
	@Digits (integer = 5, fraction = 0, message = "Please enter a valid 5-digit zip code")
	private int zip;
	private String exp_date;

	@Override
	public String toString() {
		return String.format("card number: %s", card_number);
	}
}