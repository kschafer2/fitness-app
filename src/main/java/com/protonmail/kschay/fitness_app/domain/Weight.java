package com.protonmail.kschay.fitness_app.domain;

public class Weight {

    private double value;
    private WeightUnit weightUnit;

    public Weight(double value, WeightUnit weightUnit) {
        this.value = value;
        this.weightUnit = weightUnit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }
}
