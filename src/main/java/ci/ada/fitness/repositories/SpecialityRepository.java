package ci.ada.fitness.repositories;

import ci.ada.fitness.models.Speciality;
import org.apache.catalina.mapper.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    Optional<Speciality> findBySlug(String slug);
}
