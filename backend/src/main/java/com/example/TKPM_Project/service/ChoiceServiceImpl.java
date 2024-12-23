package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Choice;
import com.example.TKPM_Project.model.Question;
import com.example.TKPM_Project.repository.ChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceServiceImpl implements ChoiceService {
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

    @Override
    public List<Choice> findByQuestion(Question question) {
        return choiceRepository.findByQuestion_Id(question.getId()); // Lấy các lựa chọn của câu hỏi theo ID

    }
}
