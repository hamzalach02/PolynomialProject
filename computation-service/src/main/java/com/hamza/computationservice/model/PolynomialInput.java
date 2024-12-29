package com.hamza.computationservice.model;

public class PolynomialInput {
    private String polynomial;
    private boolean simplify;

    // Getters and Setters
    public String getPolynomial() {
        return polynomial;
    }

    public void setPolynomial(String polynomial) {
        this.polynomial = polynomial;
    }

    public boolean isSimplify() {
        return simplify;
    }

    public void setSimplify(boolean simplify) {
        this.simplify = simplify;
    }
}
