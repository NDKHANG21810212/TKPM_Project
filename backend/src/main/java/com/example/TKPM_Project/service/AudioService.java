package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Audio;

import java.util.List;

public interface AudioService {
    List<Audio> getAllAudio();
    Audio getAudioById(Long id);
    Audio saveAudio(Audio audio);
    void deleteAudio(Long id);
}
