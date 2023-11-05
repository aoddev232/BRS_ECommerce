package brs.AI_Shop.Controller;

import brs.AI_Shop.Model.User;
import brs.AI_Shop.Repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.UUID;

@Controller
public class LoginController {

    public static int currentUserID = 0;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/register")
    public String register() {
        return "register.html";
    }

    @PostMapping("/register")
    public void registerUser(HttpServletResponse response, @RequestParam String full_name, @RequestParam String password, @RequestParam String email, @RequestParam String username) {
        StringBuilder sb = new StringBuilder();
        sb.append(full_name);
        sb.append(username);

//        String hashedPassword = "";
//        try {
//            hashedPassword = hashPassword(password, sb.toString());
//        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }

        User user = new User();
        user.setFull_name(full_name);
        user.setEmail(email);
        user.setPassword(password);
        user.setSalt(sb.toString());
        user.setUsername(username);
        user.setAdministrator(false);
        userRepository.save(user);

        try {
            response.sendRedirect("/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @PostMapping("/login")
    public void loginUser(HttpServletResponse response, @RequestParam String username, @RequestParam String password) throws IOException {
        User checkUser = userRepository.findByUsername(username);

        if ((checkUser.getPassword()).equals(password)) {
            CartController.isLoggedInt = true;
            if (checkUser.getAdministrator()) {
                try {
                    response.sendRedirect("/dashboard");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                currentUserID = checkUser.getId();
                try {
                    response.sendRedirect("/products");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                response.sendRedirect("/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
