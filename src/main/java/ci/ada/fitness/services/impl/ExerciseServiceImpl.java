package ci.ada.fitness.services.impl;

import ci.ada.fitness.models.Exercise;
import ci.ada.fitness.models.User;
import ci.ada.fitness.repositories.ExerciseRepository;
import ci.ada.fitness.services.DTO.ExerciseDTO;
import ci.ada.fitness.services.ExerciseService;
import ci.ada.fitness.services.mapper.ExerciseMapper;
import ci.ada.fitness.services.mapping.ExerciseMapping;
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

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    @Override
    public ExerciseDTO save(ExerciseDTO exerciseDTO) {
        log.debug("Request to save exercise : {}", exerciseDTO);
        final String slug = SlugifyUtils.generate(String.valueOf(exerciseDTO.getName()));
        exerciseDTO.setSlug(slug);
        Exercise exercise = exerciseMapper.toEntity(exerciseDTO);
        log.debug("Exercise after mapping{}", exercise);
        exercise = exerciseRepository.save(exercise);
        return exerciseMapper.toDto(exercise);
    }

    @Override
    public ExerciseDTO update(ExerciseDTO exerciseDTO) {
        return null;
    }

    @Override
    public ExerciseDTO update(ExerciseDTO exerciseDTO, Long id) {
        log.debug("Request to update exercice: {}", exerciseDTO);

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
        log.debug("Request to delete exercice: {}", id);

        exerciseRepository.deleteById(id);

    }

    @Override
    public Optional<ExerciseDTO> findById(Long id) {
        log.debug("Request to get exercice by id: {}", id);
        return exerciseRepository.findById(id).map(exercise -> {
            return exerciseMapper.toDto(exercise);
        });
    }

    @Override
    public Optional<ExerciseDTO> findBySlug(String slug) {
        log.debug("Request to get exercice by slug: {}", slug);
        return exerciseRepository.findBySlug(slug).map(exercise -> {
            return exerciseMapper.toDto(exercise);
        });
    }

    @Override
    public ExerciseDTO partialUpdate(ExerciseDTO exerciseDTO, Long id) {

        return exerciseRepository.findById(id).map(exercise -> {
            ExerciseMapping.partialUpdate(exercise, exerciseDTO);
            return exercise;
        }).map(exerciseRepository::save).map(exerciseMapper::toDto).orElse(null);
    }
}
