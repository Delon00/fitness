package ci.ada.fitness.repositories;

import ci.ada.fitness.models.Coach;
import ci.ada.fitness.models.PersonalizedAdvice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoachRepository extends JpaRepository<Coach, Long> {
    Optional<Coach> findBySlug(String slug);
}
