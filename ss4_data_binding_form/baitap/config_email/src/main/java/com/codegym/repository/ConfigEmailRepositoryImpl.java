package com.codegym.repository;

import com.codegym.entity.ConfigEmail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ConfigEmailRepositoryImpl implements ConfigEmailRepository{
    private static Map<String, ConfigEmail> configEmailMap = new HashMap<>();
    static {
        configEmailMap.put("1", new ConfigEmail("1","English","25",false,"Thor: King,Asgard"));
    }
    @Override
    public List<ConfigEmail> findAll() {
        return new ArrayList<>(configEmailMap.values());
    }

    @Override
    public void update(ConfigEmail configEmail) {
        if (configEmailMap.containsKey(configEmail.getId())) {
            configEmailMap.put(configEmail.getId(), configEmail);
        }
    }

    @Override
    public ConfigEmail findById(String id) {
            return configEmailMap.get(id);
    }

}
