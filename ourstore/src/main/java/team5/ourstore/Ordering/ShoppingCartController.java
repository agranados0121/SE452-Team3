package team5.ourstore.Ordering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/checkout")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    //  Product page
    @GetMapping("/product-page/add-to-cart")
    public ModelAndView addToCart(long product_id) {
        shoppingCartService.addToCart(shoppingCartService.getProductService().getByProductid(product_id));
        return viewCart();
    }

    //  Checkout page
    @PostMapping("checkout-page")
    public ModelAndView viewCart() {
        ModelAndView model = new ModelAndView("view-cart");
        model.addObject("products", shoppingCartService.getCartContents());
        model.addObject("price", shoppingCartService.calculateTotal());
        return model;
    }


    @GetMapping("/checkout-page/remove-from-cart")
    public ModelAndView removeFromCart(long product_id) {
        shoppingCartService.removeFromCart(shoppingCartService.getProductService().getByProductid(product_id));
        return viewCart();
    }

    //  Show Order confirmation
    @PostMapping("/checkout-page/check-out")
    public ModelAndView checkOut() {
        ModelAndView model = new ModelAndView("check-out");
        CustomerOrder order = shoppingCartService.checkOut();
        model.addObject("order", order);
        return model;
    }
}
