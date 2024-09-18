package ci.ada.fitness.repositories;

import ci.ada.fitness.models.Exercise;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
   Optional<Exercise> findBySlug(String slug);
}

