package ci.ada.fitness.repositories;

import ci.ada.fitness.models.Performance;
import ci.ada.fitness.services.DTO.PerformanceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface PerformanceRepository extends JpaRepository<Performance, Long> {
    Optional<Performance> findBySlug(String slug);
    // Vous pouvez ajouter des méthodes spécifiques si nécessaire
}
