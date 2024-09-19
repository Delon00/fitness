package ci.ada.fitness.repositories;

import ci.ada.fitness.models.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}
