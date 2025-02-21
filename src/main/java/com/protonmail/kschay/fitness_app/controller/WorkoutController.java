package com.protonmail.kschay.fitness_app.controller;

import com.protonmail.kschay.fitness_app.database.WorkoutRepository;
import com.protonmail.kschay.fitness_app.domain.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    private final WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Workout>> getAll() {
        return ResponseEntity.ofNullable(workoutRepository.findAll());
    }

    @PostMapping("/saveAll")
    public ResponseEntity<Iterable<Workout>> saveAll(Iterable<Workout> workouts) {
        return ResponseEntity.ofNullable(workoutRepository.saveAll(workouts));
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Iterable<Workout>> deleteAll(Iterable<Workout> workouts) {
        workoutRepository.deleteAll(workouts);
        return ResponseEntity.ok().build();
    }
}
