package ci.ada.fitness.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PerformanceRepository extends JpaRepository<Performance, Long> {
    Optional<Performance> findBySlug(String slug);
    // Vous pouvez ajouter des méthodes spécifiques si nécessaire
}
