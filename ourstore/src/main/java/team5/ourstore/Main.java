package team5.ourstore;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import team5.ourstore.Ordering.*;
import team5.ourstore.Stock.InventoryRepository;
import team5.ourstore.Stock.Product;
import team5.ourstore.Stock.ProductController;
import team5.ourstore.Stock.ProductRepository;
import team5.ourstore.Store.*;

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
    public CommandLineRunner shoppingTest(InventoryRepository inventoryRepository, ProductRepository productRepository, ShoppingCartRepository cartRepository, PromotionRepository promotionRepository) {
        return(args) ->{
            ProductController productController = new ProductController(inventoryRepository, productRepository, promotionRepository);
            ShoppingCartController cartController = new ShoppingCartController(productController, cartRepository);
            Product p = productRepository.findByProductid(3l);
            cartController.addToCart(p);
            p = productRepository.findByProductid(4l);
            cartController.addToCart(p);
            p = productRepository.findByProductid(5l);
            cartController.addToCart(p);
            for (Product product : cartController.getCartContents()) {
                System.out.println(product.getProductname());
            }
            System.out.println(cartController.calculateTotal());
        };
    }
}
