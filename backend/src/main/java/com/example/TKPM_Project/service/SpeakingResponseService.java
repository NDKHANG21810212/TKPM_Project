package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.SpeakingResponse;

import java.util.List;

public interface SpeakingResponseService {
    SpeakingResponse findById(Long id);
    List<SpeakingResponse> findAll();
    SpeakingResponse save(SpeakingResponse speakingResponse);
    void deleteById(Long id);
}
