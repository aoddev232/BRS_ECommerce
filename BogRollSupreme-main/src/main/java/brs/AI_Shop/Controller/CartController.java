package brs.AI_Shop.Controller;

import brs.AI_Shop.Model.Order;
import brs.AI_Shop.Model.Product;
import brs.AI_Shop.Repository.OrderRepository;
import brs.AI_Shop.Repository.ProductRepository;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

@Controller
public class CartController {
    private HashMap<Integer, Product> cart = new HashMap<>();
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    private int count = 1;
    public static boolean isLoggedInt = false;
    LocalDate today = LocalDate.now();
    DayOfWeek dayOfWeek = today.getDayOfWeek();
    String dayOfWeekString = dayOfWeek.getDisplayName(
            TextStyle.FULL,
            Locale.getDefault()
    );

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("keys", cart.keySet());
        model.addAttribute("products", cart.entrySet());
        model.addAttribute("hashmap", cart);
        return "cart.html";
    }

    @PostMapping("/products")
    public void addToCart(@RequestParam("product") int sku, HttpServletResponse response) throws IOException {
        // Retrieve the corresponding product object from your database or wherever your products are stored
        if (isLoggedInt) {
            Product product = productRepository.findBySku(sku);
            cart.put(count, product);
            count++;
            try {
                response.sendRedirect("/products");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Please log in before adding items to cart');");
            out.println("window.location.href = '/login';");
            out.println("</script>");
        }
    }

    @PostMapping("/remove")
    public void removeFromCart(@RequestParam("key") int key, HttpServletResponse response) {
        cart.remove(key);
        try{
            response.sendRedirect("/cart");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/cartCount")
    @ResponseBody
    public Map<String, Integer> getCount() {
        Map<String, Integer> response = new HashMap<>();
        response.put("count", cart.size());
        return response;
    }

    @GetMapping("/totalPrice")
    @ResponseBody
    public Map<String, Double> getTotalPrice() {
        List<Integer> keys = new ArrayList<>(cart.keySet());    //Getting the keys of the current cart items
        double totalPrice = 0;
        for(int i=0; i<cart.size(); i++){   //For loop to go through all items
            int key = keys.get(i);  //Setting the key for each item
            Product product = cart.get(key);    //Getting the current product being checked
            double currentPrice = product.getPrice();     //Setting the currentprice to be the price of that item
            totalPrice = totalPrice + currentPrice;
            //Finding the price of all items
        }
        Map<String, Double> response = new HashMap<>();
        response.put("totalPrice", totalPrice);
        return response;
    }

    @GetMapping("/payment")
    public String Currencies(Model model) {
        List<Integer> keys = new ArrayList<>(cart.keySet());    //Getting the keys of the current cart items
        int totalPrice = 0;
        for(int i=0; i<cart.size(); i++){   //For loop to go through all items
            int key = keys.get(i);  //Setting the key for each item
            Product product = cart.get(key);    //Getting the current product being checked
            int currentPrice = (int)product.getPrice();     //Setting the currentprice to be the price of that item
            totalPrice = totalPrice + currentPrice;     //Finding the price of all items
            List<String> currencies = new ArrayList<>();
        }
        model.addAttribute("euroValue", "€" + totalPrice + ".0");
        model.addAttribute("dollarValue", "$" + totalPrice*1.06);
        model.addAttribute("poundValue", "£" + totalPrice*0.88);
        return "payment.html";
    }

    @PostMapping("/home")
    public String paymentComplete(HttpServletResponse response){

        for(Map.Entry<Integer, Product> entry : cart.entrySet()){
            Order newOrder = new Order();
            newOrder.setOrder_number(Order.order_count);
            newOrder.setSku(entry.getValue().getSku());
            newOrder.setProduct_name(entry.getValue().getProduct_name());
            newOrder.setPrice(entry.getValue().getPrice());
            newOrder.setUser_id(LoginController.currentUserID);
            newOrder.setFulfilled(false);
            newOrder.setDay_ordered(dayOfWeekString);
            orderRepository.save(newOrder);
            Order.order_count++;
        }
        cart.clear();

        return ("redirect:/index/{ex}").replace("{ex}", "Payment Successful");
    }

}




