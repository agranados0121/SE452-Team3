package team5.ourstore.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import team5.ourstore.Stock.Category;
import team5.ourstore.Stock.ProductService;

@Controller
public class HomeController {
    
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
}
