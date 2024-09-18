package ci.ada.fitness.repositories;

import ci.ada.fitness.models.PersonalizedAdvice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface PersonalizedAdviceRepository extends JpaRepository<PersonalizedAdvice, Long> {
    Optional<PersonalizedAdvice> findBySlug(String slug);
    // Vous pouvez ajouter des méthodes spécifiques si nécessaire
}

