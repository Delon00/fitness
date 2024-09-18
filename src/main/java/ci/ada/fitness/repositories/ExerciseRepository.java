package ci.ada.fitness.repositories;

import ci.ada.fitness.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
   List<Exercise> findByIdIn(List<Long> ids);
}

