package team5.ourstore.Ordering;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team5.ourstore.Stock.Product;
import team5.ourstore.Stock.ProductService;
import team5.ourstore.UserType.Customer;

@Service
public class ShoppingCartService {

    private ShoppingCartRepository cartRepository;
    private ProductService productService;
    private OrderRepository orderRepository;
    private Customer customer;
    private ShoppingCart cart;

    @Autowired
    public ShoppingCartService (ProductService productService, ShoppingCartRepository cartRepository, OrderRepository orderRepository) {
        this.productService = productService;
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
        this.customer = new Customer();
        this.cart = new ShoppingCart();
    }
    
    public void addToCart(Product product) {
        if (productService.isInStock(product)) {
            cart.getProducts().add(product);
        }
        cartRepository.save(cart);
    }

    public void removeFromCart(Product product) {
        cart.getProducts().remove(product);
        cartRepository.save(cart);
    }

    public ShoppingCart addShoppingCart(ShoppingCart ShoppingCart) {
        return cartRepository.save(ShoppingCart);
    }

    public List<ShoppingCart> getCarts() {
        return cartRepository.findAll();
    }

    public float calculateTotal() {
        float salePrice = 0.0f;
        for (Product product : cart.getProducts()) {
            float tempPrice = product.getPrice();
            tempPrice *= productService.getDiscount(product.getProductid());
            salePrice += tempPrice;
        }
        return salePrice;
    }

    public List<Product> getCartContents() {
        return cart.getProducts();
    }

    //  Updates inventory, saves order in repository
    public void checkOut() {
        for (Product product : getCartContents())
            productService.updateInventory(product.getProductid());
        System.out.println("inventory updated...");
        CustomerOrder order = new CustomerOrder();
        System.out.println("order created...");
        System.out.println(order.getOrderid() + "order id set...");
        order.setCustomerid(cart.getCustomerid());
        System.out.println(cart.getCustomerid() + "customer id set...");
        SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-DD");
        order.setOrderdate(new String(date.format(new Date())));
        System.out.println(cart.getCustomerid() + "order date set...");
        order.setShipdate(new String(date.format(new Date())));
        System.out.println(cart.getCustomerid() + "ship date set...");
        orderRepository.save(order);
    }

    //  Access method - unnecessary?
    public ProductService getProductService() {
        return productService;
    }
}
