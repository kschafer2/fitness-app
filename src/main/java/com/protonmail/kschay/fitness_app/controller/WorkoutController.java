package com.protonmail.kschay.fitness_app.controller;

import com.protonmail.kschay.fitness_app.database.WorkoutRepository;
import com.protonmail.kschay.fitness_app.domain.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workout")
public class WorkoutController extends CrudController<Workout, String> {

    @Autowired
    public WorkoutController(WorkoutRepository workoutRepository) {
        super(workoutRepository);
    }
}
