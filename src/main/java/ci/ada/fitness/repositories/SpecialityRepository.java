package ci.ada.fitness.repositories;

import ci.ada.fitness.models.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
