package team5.ourstore.Ordering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import team5.ourstore.Stock.Product;
import team5.ourstore.Stock.ProductController;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    private ProductController productController;
    private ShoppingCartRepository cartRepository;
    private ShoppingCart cart = new ShoppingCart();

    @Autowired
    public ShoppingCartController (ProductController productController, ShoppingCartRepository cartRepository) {
        this.productController = productController;
        this.cartRepository = cartRepository; 
    }

    @PostMapping("/view-cart")
    public ModelAndView viewCart() {
        ModelAndView model = new ModelAndView("/shopping-cart");
        model.addObject("products", getCartContents());
        model.addObject("price", calculateTotal());
        return model;
    }

    @GetMapping("/add-to-cart")
    public ModelAndView addToCart(long product_id) {
        addToCart(productController.getByProductid(product_id));
        return viewCart();
    }

    @GetMapping("/remove-from-cart")
    public ModelAndView removeFromCart(long product_id) {
        removeFromCart(productController.getByProductid(product_id));
        return viewCart();
    }

    @GetMapping("/checkout")
    public ModelAndView checkOut(int product_id, int cart_id) {
        //  checkOut();
        //  error handling for cart svc error thrown if not in stocj
        return viewCart();
    }

    //  Services / Business logic

    public void addToCart(Product product) {
        if (productController.isInStock(product)) {
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
            tempPrice *= productController.getDiscount(product.getProductid());
            salePrice += tempPrice;
        }
        return salePrice;
    }

    //  Implement Checkout

    public List<Product> getCartContents() {
        return cart.getProducts();
    }
}
