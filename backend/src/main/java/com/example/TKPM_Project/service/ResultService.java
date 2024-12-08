package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Result;
import java.util.List;

public interface ResultService {
    Result findById(Long id);
    List<Result> findAll();
    Result save(Result result);
    void deleteById(Long id);
}
