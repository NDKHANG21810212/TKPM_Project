package src.main.java.com.example.TKPM_Project.service;

import src.main.java.com.example.TKPM_Project.model.SpeakingResponse;

import java.util.List;

public interface SpeakingResponseService {
    SpeakingResponse findById(Long id);
    List<SpeakingResponse> findAll();
    SpeakingResponse save(SpeakingResponse speakingResponse);
    void deleteById(Long id);
}
