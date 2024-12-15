package com.example.TKPM_Project.controller;

import com.example.TKPM_Project.model.Audio;
import com.example.TKPM_Project.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audios")
@CrossOrigin(origins = "http://localhost:3000")
public class AudioController {
    @Autowired
    private AudioService audioService;

    @GetMapping
    public ResponseEntity<List<Audio>> getAllAudios() {
        return ResponseEntity.ok(audioService.getAllAudio());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Audio> getAudioById(@PathVariable Long id) {
        return ResponseEntity.ok(audioService.getAudioById(id));
    }

    @PostMapping
    public ResponseEntity<Audio> createAudio(@RequestBody Audio audio) {
        return ResponseEntity.ok(audioService.saveAudio(audio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAudio(@PathVariable Long id) {
        audioService.deleteAudio(id);
        return ResponseEntity.noContent().build();
    }
}
