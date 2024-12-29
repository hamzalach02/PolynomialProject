package com.hamza.computationservice.service;

import org.apache.commons.math3.analysis.solvers.NewtonRaphsonSolver;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ComputationService {

    public List<Double> computeRoots(String polynomial) {
        // Dummy roots for demonstration purposes
        return Arrays.asList(-2.0, 1.0, 3.0);
    }

    public String factorizePolynomial(String polynomial) {
        // Dummy factorized form for demonstration purposes
        return "(x + 2)(x - 1)(x - 3)";
    }
}
