package team5.ourstore.Stock;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    //  Product Page
    //  Implement add-to-cart button (using product service)
    @PostMapping("/product-page")
    public ModelAndView viewProduct(Product product) {
        ModelAndView model = new ModelAndView("/product-page");
        model.addObject("product", product);
        return model;
    }

    //  Admin / Products
    @GetMapping("/admin-home")
    public ModelAndView viewEditForm() {
        ModelAndView model = new ModelAndView("/admin-home");
        Product product = new Product();
        model.addObject("product", product);
        return model;
    }

    @PostMapping("/admin-home")
    public ModelAndView submitEditForm(Product product) {
        ModelAndView model = new ModelAndView("/admin-home");
        for (Product p : productService.getProductCatalog()) {
            if (p.getProductid() == product.getProductid()) {
                productService.removeProductFromCatalog(p);
            }
            productService.addProductToCatalog(product);
        }
        return model;
    }
}
