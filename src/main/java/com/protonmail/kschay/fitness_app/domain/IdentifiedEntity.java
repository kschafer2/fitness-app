package com.protonmail.kschay.fitness_app.domain;

public interface IdentifiedEntity<ID> {

    ID getId();

    void setId(ID id);
}
