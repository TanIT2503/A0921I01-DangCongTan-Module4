package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary")
    public String dictionary(@RequestParam String word, Model model){
        Map<String, String> words = new HashMap<>();
        words.put("Cat", "Con mèo");
        words.put("Dog", "Con chó");
        words.put("Pig", "Con lợn");
        words.put("Owl", "Chim cú");
        words.put("Cow", "Con bò");
        String result = words.get(word);
        model.addAttribute("word",word);
        model.addAttribute("result",result);
        if (model == null){
            String notFound = "Không tìm thấy";
            model.addAttribute("notfound",notFound);
        }
        return "views/dictionary";
    }
}
