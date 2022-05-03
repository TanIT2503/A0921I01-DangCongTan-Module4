package com.codegym.service;

import com.codegym.entity.MedicalDeclaration;

import java.util.List;

public interface MedicalDeclarationService {
    List<MedicalDeclaration> findAll();
    void add(MedicalDeclaration medicalDeclaration);
    void update(MedicalDeclaration medicalDeclaration);
    MedicalDeclaration findById(String id);
}
