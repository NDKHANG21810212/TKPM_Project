package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Audio;
import com.example.TKPM_Project.repository.AudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudioServiceImpl implements AudioService {
    @Autowired
    private AudioRepository audioRepository;
    @Override
    public List<Audio> getAllAudio() {
        return audioRepository.findAll();
    }
    @Override
    public Audio getAudioById(Long id) {
        return audioRepository.findById(id).orElse(null);
    }
    @Override
    public Audio saveAudio(Audio audio){
        return audioRepository.save(audio);
    }
    public void deleteAudio(Long id){
        audioRepository.deleteById(id);
    }
}
