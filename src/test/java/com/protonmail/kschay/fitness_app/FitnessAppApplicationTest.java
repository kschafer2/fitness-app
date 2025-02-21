package com.protonmail.kschay.fitness_app;

import com.protonmail.kschay.fitness_app.domain.*;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;

class FitnessAppApplicationTest {

    @Test
    void testMain() {
        final Exercise legPress = new Exercise();
        legPress.setName("Leg Press");
        legPress.setDescription("Leg Press description");

        final ExerciseSet legPressSet = new ExerciseSet();
        legPressSet.setExercise(legPress);
        legPressSet.setWeight(new Weight(250, WeightUnit.POUNDS));
        legPressSet.setReps(10);
        final Rest legPressRest = new Rest(60);
        legPressSet.setRest(legPressRest);

        final ExerciseSetBlock legPressSetBlock = new ExerciseSetBlock(legPressSet, 4);

        final Exercise benchPress = new Exercise();
        benchPress.setName("Bench Press");
        benchPress.setDescription("Bench Press description");

        final ExerciseSet benchPressSet = new ExerciseSet();
        benchPressSet.setExercise(benchPress);
        benchPressSet.setWeight(new Weight(125, WeightUnit.POUNDS));
        benchPressSet.setReps(8);
        final Rest benchPressRest = new Rest(120);
        benchPressSet.setRest(benchPressRest);

        final ExerciseSetBlock benchPressSetBlock = new ExerciseSetBlock(benchPressSet, 3);

        final Workout workout = new Workout();
        workout.setExercises(new LinkedList<>());
        workout.getExercises().add(legPressSetBlock);
        workout.getExercises().add(benchPressSetBlock);

        LocalDateTime startDateTime = workout.start();
        System.out.println(startDateTime);
        try {
            Thread.sleep(64000);
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted!");
            Thread.currentThread().interrupt();
        }
        LocalDateTime endDateTime = workout.end();
        System.out.println(endDateTime);
        Duration duration = workout.getDuration();
        long days = duration.toDays();
        long hours = duration.minusDays(days).toHours();
        long minutes = duration.minusHours(hours).toMinutes();
        long seconds = duration.minusMinutes(minutes).getSeconds();
        long milliseconds = duration.minusSeconds(seconds).toMillis();
        System.out.println(duration);
    }
}
