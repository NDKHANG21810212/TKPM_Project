package src.main.java.com.example.TKPM_Project.service;

import src.main.java.com.example.TKPM_Project.model.Category;
import src.main.java.com.example.TKPM_Project.model.Choice;

import java.util.List;

public interface ChoiceService {
    Choice findById(Long id);
    List<Choice> findAll();
    Choice save(Choice choice);
    void deleteById(Long id);
}
