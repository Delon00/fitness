package ci.ada.fitness.services.impl;

import ci.ada.fitness.services.DTO.TrainingProgramDTO;
import ci.ada.fitness.services.TrainingProgramService;

import java.util.List;
import java.util.Optional;

public class TrainingProgramServiceImpl implements TrainingProgramService {
    @Override
    public TrainingProgramDTO save(TrainingProgramDTO trainingProgramDTO) {
        return null;
    }

    @Override
    public TrainingProgramDTO update(TrainingProgramDTO trainingProgramDTO) {
        return null;
    }

    @Override
    public TrainingProgramDTO update(TrainingProgramDTO trainingProgramDTO, Long id) {
        return null;
    }

    @Override
    public Optional<TrainingProgramDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<TrainingProgramDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<TrainingProgramDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<TrainingProgramDTO> findBySlug(String slug) {
        return Optional.empty();
    }

    @Override
    public TrainingProgramDTO partialUpdate(TrainingProgramDTO trainingProgramDTO, Long id) {
        return null;
    }
}
