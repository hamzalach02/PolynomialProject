package com.hamza.computationservice.model;

import java.util.List;

public class ComputationResult {
    private String polynomial;
    private List<Double> roots;
    private String factorizedForm;

    // Constructor
    public ComputationResult(String polynomial, List<Double> roots, String factorizedForm) {
        this.polynomial = polynomial;
        this.roots = roots;
        this.factorizedForm = factorizedForm;
    }

    // Getters and Setters
    public String getPolynomial() {
        return polynomial;
    }

    public void setPolynomial(String polynomial) {
        this.polynomial = polynomial;
    }

    public List<Double> getRoots() {
        return roots;
    }

    public void setRoots(List<Double> roots) {
        this.roots = roots;
    }

    public String getFactorizedForm() {
        return factorizedForm;
    }

    public void setFactorizedForm(String factorizedForm) {
        this.factorizedForm = factorizedForm;
    }
}
