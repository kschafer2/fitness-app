package com.protonmail.kschay.fitness_app.controller;

import com.protonmail.kschay.fitness_app.database.ExerciseSetBlockRepository;
import com.protonmail.kschay.fitness_app.domain.ExerciseSetBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exerciseSetBlock")
public class ExerciseSetBlockController extends CrudController<ExerciseSetBlock, String>{

    @Autowired
    public ExerciseSetBlockController(ExerciseSetBlockRepository exerciseSetBlockRepository) {
        super(exerciseSetBlockRepository);
    }
}
