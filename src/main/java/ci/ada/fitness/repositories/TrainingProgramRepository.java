package ci.ada.fitness.repositories;

import ci.ada.fitness.models.TrainingProgram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TrainingProgramRepository extends JpaRepository<TrainingProgram, Long> {
    Optional<TrainingProgram> findBySlug(String slug);
}
