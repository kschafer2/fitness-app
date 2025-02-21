package com.protonmail.kschay.fitness_app.domain;

public class ExerciseSet {

    private Exercise exercise;
    private Weight weight;
    private int reps;
    private Rest rest;

    public ExerciseSet(ExerciseSet exerciseSet) {
        this.exercise = exerciseSet.getExercise();
        Weight weightToCopy = exerciseSet.getWeight();
        this.weight = new Weight(weightToCopy.getValue(), weightToCopy.getWeightUnit());
        this.reps = exerciseSet.getReps();
        Rest restToCopy = exerciseSet.getRest();
        this.rest = new Rest(restToCopy.getDuration());
    }

    public ExerciseSet() {}

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public Rest getRest() {
        return rest;
    }

    public void setRest(Rest rest) {
        this.rest = rest;
    }
}
