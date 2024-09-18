package ci.ada.fitness.repositories;

import ci.ada.fitness.models.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface RoutineRepository extends JpaRepository<Routine, Long> {
    Optional<Routine> findBySlug(String slug);
}
