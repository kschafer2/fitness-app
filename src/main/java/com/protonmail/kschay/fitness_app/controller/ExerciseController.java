package com.protonmail.kschay.fitness_app.controller;

import com.protonmail.kschay.fitness_app.database.ExerciseRepository;
import com.protonmail.kschay.fitness_app.domain.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Exercise>> getAll() {
        return ResponseEntity.ofNullable(exerciseRepository.findAll());
    }

    @PostMapping("/saveAll")
    public ResponseEntity<Iterable<Exercise>> saveAll(Iterable<Exercise> workouts) {
        return ResponseEntity.ofNullable(exerciseRepository.saveAll(workouts));
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Iterable<Exercise>> deleteAll(Iterable<Exercise> workouts) {
        exerciseRepository.deleteAll(workouts);
        return ResponseEntity.ok().build();
    }
}
