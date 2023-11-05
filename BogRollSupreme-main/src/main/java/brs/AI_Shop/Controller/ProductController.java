package brs.AI_Shop.Controller;

import brs.AI_Shop.Model.Product;
import brs.AI_Shop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String products(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

    @GetMapping("/product")
    public String view() {
        return "item.html";
    }

    @GetMapping("/product/{sku}")
    public String productPage(@PathVariable("sku") int sku, Model model) {
        Optional<Product> product = productRepository.findById(sku);
        model.addAttribute("product", product.orElse(null));
        return "item.html";
    }

}
