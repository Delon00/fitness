package ci.ada.fitness.repositories;

import ci.ada.fitness.models.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoutineRepository extends JpaRepository<Routine, Long> {
    // Vous pouvez ajouter des méthodes spécifiques si nécessaire
}
