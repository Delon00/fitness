package ci.ada.fitness.repositories;

import ci.ada.fitness.models.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PerformanceRepository extends JpaRepository<Performance, Long> {
    // Vous pouvez ajouter des méthodes spécifiques si nécessaire
}
