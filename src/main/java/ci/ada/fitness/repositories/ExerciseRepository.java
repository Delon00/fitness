package ci.ada.fitness.repositories;

import ci.ada.fitness.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    // Vous pouvez ajouter des méthodes spécifiques si nécessaire
}

