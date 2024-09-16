package ci.ada.fitness.repositories;

import ci.ada.fitness.models.TrainingProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TrainingProgramRepository extends JpaRepository<TrainingProgram, Long> {
    // Vous pouvez ajouter des méthodes spécifiques si nécessaire
}
