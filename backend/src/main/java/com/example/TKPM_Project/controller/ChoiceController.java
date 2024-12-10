package com.example.TKPM_Project.controller;
import com.example.TKPM_Project.model.Choice;
import com.example.TKPM_Project.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/choices")
public class ChoiceController {

    @Autowired
    private ChoiceService choiceService;

    // Lấy tất cả các lựa chọn
    @GetMapping
    public ResponseEntity<List<Choice>> getAllChoices() {
        List<Choice> choices = choiceService.findAll();
        return ResponseEntity.ok(choices);
    }

    // Lấy lựa chọn theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Choice> getChoiceById(@PathVariable Long id) {
        Choice choice = choiceService.findById(id);
        return choice != null ? ResponseEntity.ok(choice) : ResponseEntity.notFound().build();
    }

    // Thêm lựa chọn mới
    @PostMapping
    public ResponseEntity<Choice> createChoice(@RequestBody Choice choice) {
        Choice createdChoice = choiceService.save(choice);
        return ResponseEntity.ok(createdChoice);
    }
    // Xóa lựa chọn
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChoice(@PathVariable Long id) {
        choiceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
