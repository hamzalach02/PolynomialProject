package com.hamza.resultservice.controller;

import com.hamza.resultservice.model.ComputationResult;
import com.hamza.resultservice.service.ResultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public List<ComputationResult> getResults() {
        return resultService.getAllResults();
    }
}
