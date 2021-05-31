package team5.ourstore.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import team5.ourstore.Stock.ProductRepository;
import team5.ourstore.Stock.ProductService;

@Controller
public class HomeController {

    
    private ProductService ps;

    @Autowired
    public void setProductService(ProductService ps){
        this.ps = ps;
    }
    @RequestMapping("")
    public String showAll(Model model){
        model.addAttribute("products", ps.getProductCatalog());
        return "home-page";
    }
    /*public ModelAndView home(){
        ModelAndView mv = new ModelAndView("home-page");
        return mv;
    }*/

    
}
