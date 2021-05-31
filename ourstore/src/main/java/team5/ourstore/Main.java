package team5.ourstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import team5.ourstore.Ordering.*;
import team5.ourstore.Stock.Product;
import team5.ourstore.Stock.ProductRepository;
import team5.ourstore.Stock.ProductService;
import team5.ourstore.Store.ProductReview;

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
    public CommandLineRunner shoppingTest(ProductRepository productRepository, ProductService productService, ShoppingCartRepository cartRepository, OrderRepository orderRepository) {
        return(args) ->{
            ShoppingCartService shoppingCartService = new ShoppingCartService(productService, cartRepository, orderRepository);
            Product p = productRepository.findByProductid(3l);
            shoppingCartService.addToCart(p);
            p = productRepository.findByProductid(4l);
            shoppingCartService.addToCart(p);
            p = productRepository.findByProductid(5l);
            shoppingCartService.addToCart(p);
            for (Product product : shoppingCartService.getCartContents()) {
                System.out.println(product.getProductname());
            }
            System.out.println(shoppingCartService.calculateTotal());
            shoppingCartService.checkOut();
            for (CustomerOrder order : orderRepository.findAll()) {
                System.out.println(order.getOrderdate());
                System.out.println(order.getShipdate());
            }
        };
    }
}
