package com.protonmail.kschay.fitness_app.controller;

import com.protonmail.kschay.fitness_app.database.ExerciseRepository;
import com.protonmail.kschay.fitness_app.domain.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController extends CrudController<Exercise, String>{

    @Autowired
    public ExerciseController(ExerciseRepository exerciseRepository) {
        super(exerciseRepository);
    }
}
