package team5.ourstore.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    
    @GetMapping("/signin")
    public ModelAndView login(){
        return new ModelAndView("login");
    }
}
