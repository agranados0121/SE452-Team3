package team5.ourstore.Ordering;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team5.ourstore.Stock.Product;
import team5.ourstore.Stock.ProductService;

@Service
public class ShoppingCartService {

    private ShoppingCartRepository cartRepository;
    private ProductService productService;
    private OrderRepository orderRepository;
    private ShoppingCart cart;

    @Autowired
    public ShoppingCartService (ProductService productService, ShoppingCartRepository cartRepository, OrderRepository orderRepository) {
        this.productService = productService;
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
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
    public CustomerOrder checkOut() {
        for (Product product : getCartContents())
            productService.updateInventory(product.getProductid());
        System.out.println("inventory updated...");
        CustomerOrder order = new CustomerOrder();
        order.setCustomerid(cart.getCustomerid());

        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate orderDate = LocalDate.now();
        order.setOrderdate(new String(dateFormat.format(orderDate)));
        LocalDate shipDate = LocalDate.now().plusDays(3);
        order.setShipdate(new String(dateFormat.format(shipDate)));
        orderRepository.save(order);
        return order;
    }

    //  Access method - unnecessary?
    public ProductService getProductService() {
        return productService;
    }
}
