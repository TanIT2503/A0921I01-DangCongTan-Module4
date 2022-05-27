package com.example.phonemanagement.controller;

import com.example.phonemanagement.entity.Smartphone;
import com.example.phonemanagement.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private SmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateSmartphone(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/phones/update");
        modelAndView.addObject("smartphone", smartphoneService.findByID(id));
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }

    @PutMapping("/update")
    public ResponseEntity<Smartphone> updateSmartphone(@RequestBody Smartphone smartphone) {
        if (smartphone==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.update(smartphone);
        return new ResponseEntity<>(smartphone, HttpStatus.OK);
    }
}
