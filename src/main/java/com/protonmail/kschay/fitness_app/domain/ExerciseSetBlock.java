package com.protonmail.kschay.fitness_app.domain;

import java.time.LocalDate;
import java.util.LinkedList;

public class ExerciseSetBlock {

    private LinkedList<ExerciseSet> exerciseSets;
    private LocalDate startDateTime;
    private LocalDate endDateTime;

    public ExerciseSetBlock(ExerciseSet exerciseSet, int sets) {
        this.exerciseSets = new LinkedList<>();
        for (int i = 0; i < sets; i++) {
            exerciseSets.add(new ExerciseSet(exerciseSet));
        }
    }

    public ExerciseSetBlock() {}

    public LinkedList<ExerciseSet> getExerciseSets() {
        return exerciseSets;
    }

    public void setExerciseSets(LinkedList<ExerciseSet> exerciseSets) {
        this.exerciseSets = exerciseSets;
    }
}
