package com.codegym.repository;

import com.codegym.entity.ConfigEmail;

import java.util.List;

public interface ConfigEmailRepository {
    List<ConfigEmail> findAll();
    void update(ConfigEmail configEmail);
    ConfigEmail findById(String id);
}
