package team5.ourstore.Ordering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ShoppingCart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartRepository cartRepository;

    public ShoppingCartController(ShoppingCartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @PostMapping
    public ShoppingCart addShoppingCart(ShoppingCart ShoppingCart) {
        return cartRepository.save(ShoppingCart);
    }

    @GetMapping("/all")
    public List<ShoppingCart> getAll() {
        return cartRepository.findAll();
    }

    // Test data
    
    public List<ShoppingCart> setUpTestData() {
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        shoppingCarts.add(new ShoppingCart(1, 1, 1, 1, 1, Arrays.asList(1), 250.0f));
        shoppingCarts.add(new ShoppingCart(2, 2, 2, 2, 1, Arrays.asList(2), 250.0f));
        shoppingCarts.add(new ShoppingCart(3, 3, 3, 3, 1, Arrays.asList(1, 2), 500.0f));
        shoppingCarts.add(new ShoppingCart(4, 4, 4, 4, 2, Arrays.asList(3), 250.0f));
        shoppingCarts.add(new ShoppingCart(5, 5, 5, 5, 2, Arrays.asList(4), 250.0f));
        shoppingCarts.add(new ShoppingCart(6, 6, 6, 6, 2, Arrays.asList(3, 4), 500.0f));
        shoppingCarts.add(new ShoppingCart(7, 7, 7, 7, 3, Arrays.asList(5), 250.0f));
        shoppingCarts.add(new ShoppingCart(8, 8, 8, 8, 3, Arrays.asList(6), 250.0f));
        shoppingCarts.add(new ShoppingCart(9, 9, 9, 9, 3, Arrays.asList(5, 6), 500.0f));
        shoppingCarts.add(new ShoppingCart(10, 10, 10, 10, 1, Arrays.asList(1, 1, 2, 2), 1000.0f));
        return cartRepository.saveAll(shoppingCarts);
    }
}
