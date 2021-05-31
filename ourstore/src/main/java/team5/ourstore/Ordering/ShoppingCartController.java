package team5.ourstore.Ordering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    //  Controller / Model
    @PostMapping("checkout-page")
    public ModelAndView viewCart() {
        ModelAndView model = new ModelAndView("checkout");
        model.addObject("products", shoppingCartService.getCartContents());
        model.addObject("price", shoppingCartService.calculateTotal());
        return model;
    }

    public ModelAndView addToCart(long product_id) {
        shoppingCartService.addToCart(shoppingCartService.getProductService().getByProductid(product_id));
        return viewCart();
    }

    public ModelAndView removeFromCart(long product_id) {
        shoppingCartService.removeFromCart(shoppingCartService.getProductService().getByProductid(product_id));
        return viewCart();
    }

    @GetMapping("/checkout-page")
    public ModelAndView checkOut(int product_id, int cart_id) {
        //  checkOut();
        //  error handling for cart svc error thrown if not in stock
        //  
        return viewCart();
    }
}
