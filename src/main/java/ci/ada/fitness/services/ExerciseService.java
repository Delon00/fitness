package ci.ada.fitness.services;

import ci.ada.fitness.services.DTO.ExerciseDTO;
import ci.ada.fitness.services.DTO.PersonalizedAdviceDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ExerciseService {

    ExerciseDTO save(ExerciseDTO exerciseDTO);

    ExerciseDTO update(ExerciseDTO exerciseDTO);

    ExerciseDTO update(ExerciseDTO exerciseDTO, Long id);

    Optional<ExerciseDTO> findOne(Long id);

    List<ExerciseDTO> findAll();

    void delete(Long id);

    Optional<ExerciseDTO>findById(Long id);

    Optional<ExerciseDTO> findBySlug(String slug);

    ExerciseDTO partialUpdate(ExerciseDTO exerciseDTO, Long id);
}
