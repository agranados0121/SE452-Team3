package team5.ourstore.Store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import team5.ourstore.Stock.Category;
import team5.ourstore.Stock.Product;
import team5.ourstore.Stock.ProductService;

@Controller
public class HomeController {
    
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    //@RequestMapping("home-page")
    public String viewHomePage(Model model) {
        model.addAttribute("products", productService.getProductCatalog());
        model.addAttribute("shoes", productService.getAllByCategoryid(1));
        model.addAttribute("shirts", productService.getAllByCategoryid(2));
        model.addAttribute("electronics", productService.getAllByCategoryid(3));
        return "home-page";
    }

    //@PostMapping("/product-page")
    public ModelAndView viewProductByCategory(Category category) {
        ModelAndView model = new ModelAndView("/product-page/{category.category.getCategoryname()}");
        model.addObject("items-of-given-category", productService.getAllByCategoryid(category.getCategoryid()));
        return model;
    }
}
