package com.protonmail.kschay.fitness_app.domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collection;

public class Workout {

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
}
