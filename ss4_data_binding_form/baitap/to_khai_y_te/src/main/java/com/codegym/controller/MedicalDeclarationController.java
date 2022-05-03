package com.codegym.controller;

import com.codegym.entity.MedicalDeclaration;
import com.codegym.service.MedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/declaration")
public class MedicalDeclarationController {
    @Autowired
    MedicalDeclarationService medicalDeclarationService;

    @GetMapping("/list")
    public String list(Model model) {
        List<MedicalDeclaration> medicalDeclarationList = medicalDeclarationService.findAll();
        model.addAttribute("medicalDeclaration",medicalDeclarationList);
        return "declaration/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        String[] birthday={"1990","1991","1992","1993","1994","1995","1995","2000","2001"};
        String[] genders = {"Nam","Nữ"};
        String[] nationalities = {"Việt Nam","Campuchia","Singapore","ThaiLand"};
        String[] vehicles = {"Máy bay","Tàu thuyền","Ô tô","Khác (Ghi rõ)"};
        model.addAttribute("declaration", new MedicalDeclaration());
        model.addAttribute("birthday",birthday);
        model.addAttribute("genders",genders);
        model.addAttribute("nationalities",nationalities);
        model.addAttribute("vehicles",vehicles);
        return "declaration/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("declaration") MedicalDeclaration medicalDeclaration) {
        medicalDeclarationService.add(medicalDeclaration);
        return "redirect:/declaration/list";
    }

    @GetMapping("/view/{id}")
    public String viewMedicalDeclaration(@PathVariable("id") String id, Model model) {
        String[] birthday={"1990","1991","1992","1993","1994","1995","1995","2000","2001"};
        String[] genders = {"Nam","Nữ"};
        String[] nationalities = {"Việt Nam","Campuchia","Singapore","ThaiLand"};
        String[] vehicles = {"Tàu bay","Tàu thuyền","Ô tô","Khác (Ghi rõ)"};
        MedicalDeclaration medicalDeclaration = medicalDeclarationService.findById(id);
        model.addAttribute("declaration", medicalDeclaration);
        model.addAttribute("birthday",birthday);
        model.addAttribute("genders",genders);
        model.addAttribute("nationalities",nationalities);
        model.addAttribute("vehicles",vehicles);
        return "declaration/view";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("declaration") MedicalDeclaration medicalDeclaration){
        medicalDeclarationService.update(medicalDeclaration);
        return "redirect:/declaration/list";
    }
}
