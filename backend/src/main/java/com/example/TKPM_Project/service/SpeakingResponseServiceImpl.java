package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.SpeakingResponse;
import com.example.TKPM_Project.repository.SpeakingResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakingResponseServiceImpl implements SpeakingResponseService {
    @Autowired
    private SpeakingResponseRepository speakingResponseRepository;

    @Override
    public SpeakingResponse findById(Long id) {
        return speakingResponseRepository.findById(id).orElse(null);
    }

    @Override
    public List<SpeakingResponse> findAll() {
        return speakingResponseRepository.findAll();
    }

    @Override
    public SpeakingResponse save(SpeakingResponse speakingResponse) {
        return speakingResponseRepository.save(speakingResponse);
    }

    @Override
    public void deleteById(Long id) {
        speakingResponseRepository.deleteById(id);
    }
}
