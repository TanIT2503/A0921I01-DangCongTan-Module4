package com.codegym.formatter;

import com.codegym.entity.ConfigEmail;
import com.codegym.service.ConfigEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ConfigEmailFormatter implements Formatter<ConfigEmail> {
    private ConfigEmailService configEmailService;
    @Autowired
    public ConfigEmailFormatter(ConfigEmailService configEmailService) {
        this.configEmailService = configEmailService;
    }
    @Override
    public ConfigEmail parse(String text, Locale locale) throws ParseException {
        return configEmailService.findById(text);
    }

    @Override
    public String print(ConfigEmail object, Locale locale) {
        return object.toString();
    }
}