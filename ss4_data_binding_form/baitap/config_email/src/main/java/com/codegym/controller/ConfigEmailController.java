package com.codegym.controller;

import com.codegym.entity.ConfigEmail;
import com.codegym.service.ConfigEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping ("/email")
public class ConfigEmailController {
    @Autowired
    private ConfigEmailService configEmailService;
    @GetMapping("/list")
    public String list(Model model){
        List<ConfigEmail> configEmailList = configEmailService.findAll();
        model.addAttribute("configEmailList", configEmailList);
        return "email/list";
    }
    @GetMapping( "/update/{id}")
    public String update(@PathVariable("id") String id, ModelMap model){
        String[] languages = {"English","Vietnamese","Japanese","Chinese"};
        String[] pageSizes = {"5","7", "9", "11","13","18","15","28"};
        ConfigEmail configEmail = configEmailService.findById(id);
        model.addAttribute("configEmail", configEmail);
        model.addAttribute("languages",languages);
        model.addAttribute("pageSize",pageSizes);
        return "email/update";
    }
    @PostMapping( "/update")
    public String update(@ModelAttribute("email") ConfigEmail configEmail){
        configEmailService.update(configEmail);
        return "redirect:/email/list";
    }
}
