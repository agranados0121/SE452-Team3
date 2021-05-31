package team5.ourstore.Stock;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ModelAndView viewAllProducts() {
        ModelAndView model = new ModelAndView("home-page");
        //  Use . notation to access the data fields/populate product page
        model.addObject("products", productService.getProductCatalog());
        return model;
    }

    //@PostMapping("/product-page")
    public ModelAndView viewProductByCategory(Category category) {
        ModelAndView model = new ModelAndView("/product-page/{category.category.getCategoryname()}");
        //  Use . notation to access the data fields/populate product page
        model.addObject("category", productService.getByCategoryid(category.getCategoryid()));
        return model;
    }

    //  Product Page
    //  Implement add-to-cart button (using product service)
    @PostMapping("/product-page")
    public ModelAndView viewProduct(Product product) {
        ModelAndView model = new ModelAndView("/product-page");
        //  Use . notation to access the data fields/populate product page
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
