package src.main.java.com.example.TKPM_Project.service;

import src.main.java.com.example.TKPM_Project.model.LearningGoal;
import src.main.java.com.example.TKPM_Project.model.LearningHistory;
import src.main.java.com.example.TKPM_Project.repository.LearningGoalRepository;
import src.main.java.com.example.TKPM_Project.repository.LearningHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningHistoryServiceImpl implements LearningHistoryService {
    @Autowired
    private LearningHistoryRepository learningHistoryRepository;

    @Override
    public LearningHistory findById(Long id) {
        return learningHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<LearningHistory> findAll() {
        return learningHistoryRepository.findAll();
    }

    @Override
    public LearningHistory save(LearningHistory learningHistory) {
        return learningHistoryRepository.save(learningHistory);
    }

    @Override
    public void deleteById(Long id) {
        learningHistoryRepository.deleteById(id);
    }

}
