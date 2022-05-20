package com.codegym.library.service;

import com.codegym.library.entity.Status;
import com.codegym.library.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService{
    @Autowired
    StatusRepository statusRepository;
    @Override
    public void createStatus() {
        statusRepository.save(new Status(1, "available"));
        statusRepository.save(new Status(2, "used"));
    }
}
