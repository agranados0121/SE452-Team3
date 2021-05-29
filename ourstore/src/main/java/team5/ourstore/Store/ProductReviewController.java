package team5.ourstore.Store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews/")
public class ProductReviewController {
    @Autowired
    private ProductReviewRepository reviewRepository;

    public ProductReviewController(ProductReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @PostMapping
    public ProductReview addReview(ProductReview review) {
        return reviewRepository.save(review);
    }

    @GetMapping("/all")
    public List<ProductReview> getAll() {
        return reviewRepository.findAll();
    }
	
	    // Test data
    
    public List<ProductReview> setUpTestData() {
        List<ProductReview> reviews = new ArrayList<>();
        reviews.add(new ProductReview(1, 1, "cool shoes", "chris", "2021-05-01", 0));
        reviews.add(new ProductReview(2, 2, "A+", "lucy", "2021-05-01", 5));
        reviews.add(new ProductReview(3, 3, "cool shoes, slow shipping", "mortimer", "2021-05-01", 4));
        reviews.add(new ProductReview(4, 4, "slow shoes, cool shipping", "matilda", "2021-05-01", 4));
        reviews.add(new ProductReview(5, 5, "meh", "matthew", "2021-05-01", 3));
        reviews.add(new ProductReview(6, 6, "incredible website", "gerald", "2021-05-01", 5));
        reviews.add(new ProductReview(7, 7, "expensive", "bill", "2021-05-01", 4));
        reviews.add(new ProductReview(8, 8, "wow, nice", "madelyn", "2021-05-01", 5));
        reviews.add(new ProductReview(9, 9, "favorite store in the world", "molly", "2021-05-01", 5));
        reviews.add(new ProductReview(10, 10, "ourStore is the best!", "esteban", "2021-05-01", 5));
        return reviewRepository.saveAll(reviews);
    }
}