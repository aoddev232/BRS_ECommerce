package brs.AI_Shop.Controller;

import brs.AI_Shop.Model.User;
import brs.AI_Shop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class ShopController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        boolean loginButton = true;
        if(LoginController.currentUserID != 0){
            loginButton = false;
        }
        model.addAttribute("loginButton", loginButton);
        return "index.html";
    }

    @GetMapping("/index/{ex}")
    public String checkoutProcess(@PathVariable String ex, Model model) {
        model.addAttribute("checkoutMessage", ex);
        return "index.html";
    }

}
