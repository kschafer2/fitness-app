package com.protonmail.kschay.fitness_app.database;

import com.protonmail.kschay.fitness_app.domain.ExerciseSetBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseSetBlockRepository extends JpaRepository<ExerciseSetBlock, String> {
}
