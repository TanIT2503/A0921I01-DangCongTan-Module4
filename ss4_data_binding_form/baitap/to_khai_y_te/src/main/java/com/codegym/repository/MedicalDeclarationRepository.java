package com.codegym.repository;

import com.codegym.entity.MedicalDeclaration;

import java.util.List;

public interface MedicalDeclarationRepository {
    List<MedicalDeclaration> findAll();
    void add(MedicalDeclaration medicalDeclaration);
    void update(MedicalDeclaration medicalDeclaration);
    MedicalDeclaration findById(String id);
}
