package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Choice;
import com.example.TKPM_Project.repository.ChoiceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.mockito.*;
import com.example.TKPM_Project.service.ChoiceService;
import com.example.TKPM_Project.service.ChoiceServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChoiceServiceTest {

    @Mock
    private ChoiceRepository choiceRepository;

    @InjectMocks
    private ChoiceServiceImpl choiceService;

    public ChoiceServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        long choiceId = 1;
        Choice choice = new Choice();
        choice.setId((int) choiceId);
        choice.setChoiceText("Test Choice");

        when(choiceRepository.findById(choiceId)).thenReturn(Optional.of(choice));

        Choice result = choiceService.findById(choiceId);
        assertNotNull(result);
        assertEquals("Test Choice", result.getChoiceText());
        verify(choiceRepository, times(1)).findById(choiceId);
    }

    @Test
    void testFindAll() {
        Choice choice1 = new Choice();
        choice1.setId(1);
        choice1.setChoiceText("Choice 1");

        Choice choice2 = new Choice();
        choice2.setId(2);
        choice2.setChoiceText("Choice 2");

        when(choiceRepository.findAll()).thenReturn(Arrays.asList(choice1, choice2));

        List<Choice> result = choiceService.findAll();
        assertEquals(2, result.size());
        verify(choiceRepository, times(1)).findAll();
    }

    @Test
    void testSave() {
        Choice choice = new Choice();
        choice.setChoiceText("New Choice");

        when(choiceRepository.save(choice)).thenReturn(choice);

        Choice result = choiceService.save(choice);
        assertNotNull(result);
        assertEquals("New Choice", result.getChoiceText());
        verify(choiceRepository, times(1)).save(choice);
    }

    @Test
    void testDeleteById() {
        Long choiceId = 1L;

        doNothing().when(choiceRepository).deleteById(choiceId);

        choiceService.deleteById(choiceId);
        verify(choiceRepository, times(1)).deleteById(choiceId);
    }
}
