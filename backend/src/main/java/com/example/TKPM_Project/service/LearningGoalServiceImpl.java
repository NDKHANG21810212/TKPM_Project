package src.main.java.com.example.TKPM_Project.service;

import src.main.java.com.example.TKPM_Project.model.LearningGoal;
import src.main.java.com.example.TKPM_Project.repository.LearningGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningGoalServiceImpl implements LearningGoalService {
    @Autowired
    private LearningGoalRepository learningGoalRepository;

    @Override
    public LearningGoal findById(Long id) {
        return learningGoalRepository.findById(id).orElse(null);
    }

    @Override
    public List<LearningGoal> findAll() {
        return learningGoalRepository.findAll();
    }

    @Override
    public LearningGoal save(LearningGoal learningGoal) {
        return learningGoalRepository.save(learningGoal);
    }

    @Override
    public void deleteById(Long id) {
        learningGoalRepository.deleteById(id);
    }
}
