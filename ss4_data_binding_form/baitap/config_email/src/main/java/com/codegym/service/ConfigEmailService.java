package com.codegym.service;

import com.codegym.entity.ConfigEmail;

import java.util.List;

public interface ConfigEmailService {
    List<ConfigEmail> findAll();
    void update(ConfigEmail configEmail);
    ConfigEmail findById(String id);
}
