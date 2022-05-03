package com.codegym.service;

import com.codegym.entity.ConfigEmail;
import com.codegym.repository.ConfigEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.codegym.service.ConfigEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigEmailServiceImpl implements ConfigEmailService{
    private ConfigEmailRepository configEmailRepository;
    @Autowired
    public ConfigEmailServiceImpl (ConfigEmailRepository configEmailRepository){
        this.configEmailRepository = configEmailRepository;
    }
    @Override
    public List<ConfigEmail> findAll() {
        return configEmailRepository.findAll();
    }

    @Override
    public void update(ConfigEmail configEmail) {
        configEmailRepository.update(configEmail);
    }

    @Override
    public ConfigEmail findById(String id) {
        return configEmailRepository.findById(id);
    }
}
