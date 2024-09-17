package ci.ada.fitness.services.impl;

import ci.ada.fitness.models.Exercise;
import ci.ada.fitness.repositories.ExerciseRepository;
import ci.ada.fitness.services.DTO.ExerciseDTO;
import ci.ada.fitness.services.ExerciseService;
import ci.ada.fitness.services.mapper.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
@Slf4j
@RequiredArgsConstructor

public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseMapper exerciseMapper;
    private final ExerciseRepository exerciseRepository;

    @Override
    public ExerciseDTO save(ExerciseDTO exerciseDTO) {
        log.debug("Request to save exercice: {}", exerciseDTO);
        Exercise exercise = exerciseMapper.toEntity(exerciseDTO);
        exercise = exerciseRepository.save(exercise);

        return exerciseMapper.toDto(exercise);
    }

    @Override
    public ExerciseDTO update(ExerciseDTO exerciseDTO) {

        return null;
    }

    @Override
    public ExerciseDTO update(ExerciseDTO exerciseDTO, Long id) {
        Exercise exercise = exerciseMapper.toEntity(exerciseDTO);
        exercise = exerciseRepository.save(exercise);

        return exerciseMapper.toDto(exercise);
    }

    @Override
    public Optional<ExerciseDTO> findOne(Long id) {
       return exerciseRepository.findById(id).map(exercise -> {
           return exerciseMapper.toDto(exercise);

       }) ;
    }

    @Override
    public List<ExerciseDTO> findAll() {
        return exerciseRepository.findAll().stream().map(exercise -> {
          return exerciseMapper.toDto(exercise);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        exerciseRepository.deleteById(id);

    }

    @Override
    public Optional<ExerciseDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ExerciseDTO> findBySlug(String slug) {
        return Optional.empty();
    }

    @Override
    public ExerciseDTO partialUpdate(ExerciseDTO exerciseDTO, Long id) {
        return null;
    }
}
