package com.hamza.resultservice.service;

import com.hamza.resultservice.model.ComputationResult;
import com.hamza.resultservice.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultRepository repository;

    public ResultService(ResultRepository repository) {
        this.repository = repository;
    }

    public void saveResult(ComputationResult result) {
        repository.save(result);
    }

    public List<ComputationResult> getAllResults() {
        return repository.findAll();
    }
}
