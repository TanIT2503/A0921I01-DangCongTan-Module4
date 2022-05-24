package com.codegym.shopping_cart.controller;

import com.codegym.shopping_cart.entity.Cart;
import com.codegym.shopping_cart.entity.Product;
import com.codegym.shopping_cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/")
    public String showList(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart) {
        Product product = productService.findById(id);
        if (!productService.checkId(id)) {
            return "/error-404";
        }
        cart.addProduct(product);
        return "/shopping-cart";
    }

    @GetMapping("/remove/{id}")
    public String decrease(@PathVariable Long id, @ModelAttribute Cart cart){
        Product product = productService.findById(id);
        cart.removeProduct(product);
        return "redirect:/shopping-cart";
    }

    @GetMapping("/detail/{id}")
    public String viewProductDetail(@PathVariable Long id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "/detail";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,@ModelAttribute Cart cart){
        Product product = productService.findById(id);
        cart.delete(product);
        return "redirect:/shopping-cart";
    }
}
