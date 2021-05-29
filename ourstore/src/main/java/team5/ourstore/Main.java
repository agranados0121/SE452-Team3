package team5.ourstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import team5.ourstore.Ordering.*;
import team5.ourstore.Store.*;
import team5.ourstore.UserType.Customer;
import team5.ourstore.UserType.CustomerRepository;

@EnableMongoRepositories(basePackageClasses = {PaymentInfo.class,
                            ProductReview.class,
                            ShippingInfo.class,
                            ShoppingCart.class})
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Start");
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner addCustomer(CustomerRepository repository){
        return(args) ->{
            Customer j = new Customer();
            j.setId(3);
            j.setFirst_name("Sam");
            j.setLast_name("smith");
            j.setEmail("ssmith@google.com");
            j.setPasswords("passwords");
            repository.save(j);
        };
    }
	
    @Bean
    public CommandLineRunner importMongoTestData(PaymentInfoRepository paymentRepository,
                    ProductReviewRepository reviewRepository,
                    ShippingInfoRepository shippingRepository,
                    ShoppingCartRepository cartRepository)
    {
        return(args) -> {
            paymentRepository.deleteAll();
            reviewRepository.deleteAll();
            shippingRepository.deleteAll();
            cartRepository.deleteAll();
            System.out.println("Mongo DB init...");
            PaymentInfoController paymentController = new PaymentInfoController(paymentRepository);
            ProductReviewController reviewController = new ProductReviewController(reviewRepository);
            ShippingInfoController shippingController = new ShippingInfoController(shippingRepository);
            ShoppingCartController cartController = new ShoppingCartController(cartRepository);
            paymentController.setUpTestData();
            reviewController.setUpTestData();
            shippingController.setUpTestData();
            cartController.setUpTestData();
            System.out.println("Mongo DB setup complete...");
        };
    }
}
