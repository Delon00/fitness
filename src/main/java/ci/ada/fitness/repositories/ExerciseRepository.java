package ci.ada.fitness.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
   Optional<Exercise> findBySlug(String slug);
}

