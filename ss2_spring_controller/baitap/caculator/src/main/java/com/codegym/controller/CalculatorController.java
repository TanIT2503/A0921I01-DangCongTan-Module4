package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String calculate (@RequestParam double num1, @RequestParam double num2, @RequestParam("calculator") String calculator, Model model){
        double result = 0;
        String mess="";
        switch (calculator){
            case "Addition":
                result = num1 + num2;
                break;
            case "Subtraction":
                result = num1 - num2;
                break;
            case "Multiplication":
                result = num1 * num2;
                break;
            case "Division":
                if (num2!=0){
                    result = num1 / num2;
                    mess="";}

                else {
                    mess = "It can't be divided by 0.";
                }
                break;
        }
        model.addAttribute("num1",num1);
        model.addAttribute("num2",num2);
        model.addAttribute("result",result);
        model.addAttribute("mess",mess);
        return "views/calculator";
    }
}
