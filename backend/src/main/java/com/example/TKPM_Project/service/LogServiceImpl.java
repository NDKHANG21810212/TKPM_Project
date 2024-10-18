package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.LearningGoal;
import com.example.TKPM_Project.model.Log;
import com.example.TKPM_Project.repository.LearningGoalRepository;
import com.example.TKPM_Project.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogRepository logRepository;

    @Override
    public Log findById(Long id) {
        return logRepository.findById(id).orElse(null);
    }

    @Override
    public List<Log> findAll() {
        return logRepository.findAll();
    }

    @Override
    public Log save(Log log) {
        return logRepository.save(log);
    }

    @Override
    public void deleteById(Long id) {
        logRepository.deleteById(id);
    }
}
