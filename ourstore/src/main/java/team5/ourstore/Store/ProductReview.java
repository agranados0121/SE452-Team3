package team5.ourstore.Store;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="productreview")
@Document(collection = "productreview")
public class ProductReview {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reviewid;
	int productid;
    String review;
    String reviewer;
    String reviewdate;
	@Min(value = 1, message = "You must give at least 1 star")
	@Max(value = 5, message = "You can't give more than 5 stars")
	int rating;

	@Override
	public String toString() {
		return String.format("review: %s, reviewer: %s, rating: %s", review, reviewer, rating);
	}
}