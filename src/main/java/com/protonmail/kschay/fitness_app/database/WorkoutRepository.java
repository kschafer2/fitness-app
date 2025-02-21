package com.protonmail.kschay.fitness_app.database;

import com.protonmail.kschay.fitness_app.domain.Workout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, String> {
}
