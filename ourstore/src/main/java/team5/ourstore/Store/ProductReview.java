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
@Table(name="ProductReview")
@Document(collection = "ProductReview")
public class ProductReview {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int review_id;
	private int product_id;
    private String review;
    private String reviewer;
    private String reviewDate;
	@Min(value = 1, message = "You must give at least 1 star")
	@Max(value = 5, message = "You can't give more than 5 stars")
	private int rating;

	@Override
	public String toString() {
		return String.format("review: %s, reviewer: %s, rating: %s", review, reviewer, rating);
	}
}