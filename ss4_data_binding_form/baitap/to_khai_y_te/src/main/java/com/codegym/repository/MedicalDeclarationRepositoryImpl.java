package com.codegym.repository;

import com.codegym.entity.MedicalDeclaration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MedicalDeclarationRepositoryImpl implements MedicalDeclarationRepository{
    private static Map<String,MedicalDeclaration> medicalDeclarationMap = new HashMap<>();
    static {
        medicalDeclarationMap.put("1", new MedicalDeclaration("1","DANG CONG TAN","2001","Nam","VIET NAM","005187989233","OTo","A223VN","VN123","Da Nang"));
    }
    @Override
    public List<MedicalDeclaration> findAll() {
        return new ArrayList<>(medicalDeclarationMap.values());
    }

    @Override
    public void add(MedicalDeclaration medicalDeclaration) {
        if (!medicalDeclarationMap.containsKey(medicalDeclaration.getId())) {
            medicalDeclarationMap.put(medicalDeclaration.getId(), medicalDeclaration);
        }
    }

    @Override
    public void update(MedicalDeclaration medicalDeclaration) {
        if (!medicalDeclarationMap.containsKey(medicalDeclaration.getId())) {
            medicalDeclarationMap.put(medicalDeclaration.getId(), medicalDeclaration);
        }
    }

    @Override
    public MedicalDeclaration findById(String id) {
        return medicalDeclarationMap.get(id);
    }
}
