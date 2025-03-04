package com.protonmail.kschay.fitness_app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "weight")
public class Weight implements IdentifiedEntity<String> {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;
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

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
