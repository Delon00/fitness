package ci.ada.fitness.services.impl;

import ci.ada.fitness.models.Exercise;
import ci.ada.fitness.models.User;
import ci.ada.fitness.repositories.ExerciseRepository;
import ci.ada.fitness.services.DTO.ExerciseDTO;
import ci.ada.fitness.services.ExerciseService;
import ci.ada.fitness.services.mapper.ExerciseMapper;
import ci.ada.fitness.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseMapper exerciseMapper;
    private final ExerciseRepository exerciseRepository;
    @Override
    public ExerciseDTO save(ExerciseDTO exerciseDTO) {
        log.debug("Request to save exercise: {}", exerciseDTO);
        final String slug = SlugifyUtils.generate(String.valueOf(exerciseDTO.getName()));
        exerciseDTO.setSlug(slug);
        Exercise exercise = exerciseMapper.toEntity(exerciseDTO);
        exercise = exerciseRepository.save(exercise);
        return exerciseMapper.toDto(exercise);
    }

    @Override
    public ExerciseDTO update(ExerciseDTO exerciseDTO) {
        return findOne(exerciseDTO.getId()).map(existingExercise -> {
            existingExercise.setName(exerciseDTO.getName());
            existingExercise.setDescription(exerciseDTO.getDescription());
            return save(existingExercise);
        }).orElseThrow(()-> new RuntimeException("Exercise not found"));
    }

    @Override
    public ExerciseDTO update(ExerciseDTO exerciseDTO, Long id) {
        log.debug("Request to update exercise: {}", exerciseDTO);
        exerciseDTO.setId(id);
        return update(exerciseDTO);
    }

    @Override
    public Optional<ExerciseDTO> findOne(Long id) {
        log.debug("Request to get exercise by id: {}", id);
        return exerciseRepository.findById(id).map(exerciseMapper::toDto);
    }

    @Override
    public List<ExerciseDTO> findAll() {
        log.debug("Request to get all exercises");
        return exerciseRepository.findAll().stream().map(exerciseMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete exercise: {}", id);
        exerciseRepository.deleteById(id);
    }

    @Override
    public Optional<ExerciseDTO> findById(Long id) {
        log.debug("Request to get exercise by slug: {}", id);
        return exerciseRepository.findById(id).map(exerciseMapper::toDto);
    }

    @Override
    public Optional<ExerciseDTO> findBySlug(String slug) {
        log.debug("Request to get exercise by slug: {}", slug);
        return exerciseRepository.findBySlug(slug).map(exerciseMapper::toDto);
    }
}
