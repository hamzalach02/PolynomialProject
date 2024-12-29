package com.hamza.inputservice.model;

import java.io.Serializable;

public class PolynomialInput implements Serializable {
    private String polynomial;
    private boolean simplify;

    // Default constructor
    public PolynomialInput() {}

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

    @Override
    public String toString() {
        return "PolynomialInput{" +
                "polynomial='" + polynomial + '\'' +
                ", simplify=" + simplify +
                '}';
    }
}
