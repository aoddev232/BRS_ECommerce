package brs.AI_Shop.Controller;

import brs.AI_Shop.Model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import brs.AI_Shop.Repository.OrderRepository;

import java.util.List;

@Controller
public class OrderHistoryController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orderhistory")
    public String orderHistory(Model model){
        List<Order> orders = orderRepository.findUserOrders(LoginController.currentUserID);
        model.addAttribute("orders", orders);
        return "orderhistory.html";
    }
}
