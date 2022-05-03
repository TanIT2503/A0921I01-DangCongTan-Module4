package com.codegym.service;

import com.codegym.entity.MedicalDeclaration;
import com.codegym.repository.MedicalDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDeclarationServiceImpl implements MedicalDeclarationService{
    private MedicalDeclarationRepository medicalDeclarationRepository;
    @Autowired
    public MedicalDeclarationServiceImpl(MedicalDeclarationRepository medicalDeclarationRepository){
        this.medicalDeclarationRepository = medicalDeclarationRepository;
    }
    @Override
    public List<MedicalDeclaration> findAll() {
        return medicalDeclarationRepository.findAll();
    }

    @Override
    public void add(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepository.add(medicalDeclaration);
    }

    @Override
    public void update(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepository.update(medicalDeclaration);
    }

    @Override
    public MedicalDeclaration findById(String id) {
        return medicalDeclarationRepository.findById(id);
    }
}
