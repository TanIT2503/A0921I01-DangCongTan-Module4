package com.codegym.formatter;

import com.codegym.entity.MedicalDeclaration;
import com.codegym.service.MedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Locale;

@Component
public class MedicalDeclarationFormatter implements Formatter<MedicalDeclaration> {
    private MedicalDeclarationService service;
    @Autowired
    public MedicalDeclarationFormatter(MedicalDeclarationService medicalDeclarationService) {
        this.service = medicalDeclarationService;
    }
    @Override
    public MedicalDeclaration parse(String text, Locale locale) throws ParseException {
        return service.findById(text);
    }

    @Override
    public String print(MedicalDeclaration object, Locale locale) {
        return object.toString();
    }
}
