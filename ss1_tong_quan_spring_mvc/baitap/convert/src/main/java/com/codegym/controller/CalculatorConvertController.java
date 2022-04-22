package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorConvertController {
    @GetMapping("/convert")
    public String convert(@RequestParam double rate, @RequestParam double usd, Model model ) {
        double convert = usd*rate;
        model.addAttribute("convert", convert);
        return "views/convert";
    }
}
