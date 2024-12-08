package com.example.TKPM_Project.service;

import com.example.TKPM_Project.model.Result;
import com.example.TKPM_Project.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public Result findById(Long id) {
        return resultRepository.findById(id).orElse(null);
    }

    @Override
    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    @Override
    public Result save(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public void deleteById(Long id) {
        resultRepository.deleteById(id);
    }
}
