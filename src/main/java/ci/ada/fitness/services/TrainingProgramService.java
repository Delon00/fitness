package ci.ada.fitness.services;

import ci.ada.fitness.services.DTO.TrainingProgramDTO;

import java.util.List;
import java.util.Optional;

public interface TrainingProgramService {

    TrainingProgramDTO save(TrainingProgramDTO trainingProgramDTO);

    TrainingProgramDTO update(TrainingProgramDTO trainingProgramDTO);

    TrainingProgramDTO update(TrainingProgramDTO trainingProgramDTO, Long id);

    Optional<TrainingProgramDTO> findOne(Long id);

    List<TrainingProgramDTO> findAll();

    void delete(Long id);

    Optional<TrainingProgramDTO>findById(Long id);

//    Optional<TrainingProgramDTO> findBySlug(String slug);

    TrainingProgramDTO partialUpdate(TrainingProgramDTO trainingProgramDTO, Long id);
}
