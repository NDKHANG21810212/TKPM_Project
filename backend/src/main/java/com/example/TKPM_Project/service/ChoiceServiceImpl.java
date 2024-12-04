package src.main.java.com.example.TKPM_Project.service;

import src.main.java.com.example.TKPM_Project.model.Category;
import src.main.java.com.example.TKPM_Project.model.Choice;
import src.main.java.com.example.TKPM_Project.repository.CategoryRepository;
import src.main.java.com.example.TKPM_Project.repository.ChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceServiceImpl implements ChoiceService{
    @Autowired
    private ChoiceRepository choiceRepository;

    @Override
    public Choice findById(Long id) {
        return choiceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Choice> findAll() {
        return choiceRepository.findAll();
    }

    @Override
    public Choice save(Choice choice) {
        return choiceRepository.save(choice);
    }

    @Override
    public void deleteById(Long id) {
        choiceRepository.deleteById(id);
    }
}
