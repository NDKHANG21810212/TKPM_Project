package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Category;
import com.example.TKPM_Project.model.Log;

import java.util.List;

public interface LogService {
    Log findById(Long id);
    List<Log> findAll();
    Log save(Log log);
    void deleteById(Long id);
}
