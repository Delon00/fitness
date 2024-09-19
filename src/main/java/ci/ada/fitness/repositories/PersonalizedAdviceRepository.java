package ci.ada.fitness.repositories;

import ci.ada.fitness.models.PersonalizedAdvice;
import org.apache.catalina.mapper.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;


public interface PersonalizedAdviceRepository extends JpaRepository<PersonalizedAdvice, Long> {
    Optional<PersonalizedAdvice> findBySlug(String slug);
}

