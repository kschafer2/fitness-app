package com.protonmail.kschay.fitness_app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.LinkedList;

@Entity
@Table(name = "EXERCISE_SET_BLOCK")
public class ExerciseSetBlock implements IdentifiedEntity<String> {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;
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

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
