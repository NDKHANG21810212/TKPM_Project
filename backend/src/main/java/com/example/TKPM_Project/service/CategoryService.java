package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Category;

import javax.validation.Valid;
import java.util.List;

public interface CategoryService {
    Category findById(Long id);
    List<Category> findAll();
    Category save(com.example.TKPM_Project.model.@Valid Category category);
    Category update(Long id, Category categoryDetails);
    void deleteById(Long id);
}
