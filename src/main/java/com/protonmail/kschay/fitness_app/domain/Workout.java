package com.protonmail.kschay.fitness_app.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "WORKOUT")
public class Workout implements IdentifiedEntity<String> {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;
    @ElementCollection
    @CollectionTable(name = "WORKOUT_EXERCISE_SET_BLOCK", joinColumns = @JoinColumn(name = "workout_id"))
    private Collection<ExerciseSetBlock> exercises;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Duration duration;

    public LocalDateTime start() {
        startDateTime = LocalDateTime.now();
        return startDateTime;
    }

    public LocalDateTime end() {
        endDateTime = LocalDateTime.now();
        duration = Duration.between(startDateTime, endDateTime);
        return endDateTime;
    }

    public Collection<ExerciseSetBlock> getExercises() {
        return exercises;
    }

    public void setExercises(Collection<ExerciseSetBlock> exercises) {
        this.exercises = exercises;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndTime() {
        return endDateTime;
    }

    public Duration getDuration() {
        duration = Duration.between(startDateTime, endDateTime);
        return duration;
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
