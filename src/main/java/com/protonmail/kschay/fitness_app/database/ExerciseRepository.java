package com.protonmail.kschay.fitness_app.database;

import com.protonmail.kschay.fitness_app.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String> {
}
