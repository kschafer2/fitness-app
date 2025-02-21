package com.protonmail.kschay.fitness_app.controller;

import com.protonmail.kschay.fitness_app.database.ExerciseRepository;
import com.protonmail.kschay.fitness_app.domain.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping("/get")
    public ResponseEntity<Exercise> get(@RequestParam String id) {
        return ResponseEntity.of(exerciseRepository.findById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Exercise>> getAll() {
        return ResponseEntity.ofNullable(exerciseRepository.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Exercise> save(Exercise exercise) {
        Exercise savedExercise = exerciseRepository.save(exercise);
        String id = savedExercise.getId();
        return ResponseEntity.created(URI.create(String.format("/get/%s", id)))
                .body(savedExercise);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<Iterable<Exercise>> saveAll(Iterable<Exercise> exercises) {
        Iterable<Exercise> savedExercises = exerciseRepository.saveAll(exercises);
        return ResponseEntity.created(URI.create("/getAll")).body(savedExercises);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Iterable<Exercise>> deleteAll(Iterable<Exercise> workouts) {
        exerciseRepository.deleteAll(workouts);
        return ResponseEntity.ok().build();
    }
}
