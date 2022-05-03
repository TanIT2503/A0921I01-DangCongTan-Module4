package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("list")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("product/list");
        List<Product> products = productService.findAll();
        modelAndView.addObject("products",products);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/product/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product) {
        productService.add(product);
        return "redirect:/product/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") String id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/product/view";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/product/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product) {
        productService.delete(product.getId());
        return "redirect:/product/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") String id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/product/update";
    }

    @PostMapping("/update")
    public String update(Product product){
        productService.update(product.getId(),product);
        return "redirect:/product/list";
    }

    @PostMapping("/search")
    public String search(@RequestParam("name") String name, Model model){
        model.addAttribute("products",productService.searchName(name));
        return "/product/search";
    }
}
