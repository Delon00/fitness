package ci.ada.fitness.services.impl;

import ci.ada.fitness.models.Routine;
import ci.ada.fitness.models.TrainingProgram;
import ci.ada.fitness.repositories.RoutineRepository;
import ci.ada.fitness.repositories.TrainingProgramRepository;
import ci.ada.fitness.repositories.UserRepository;
import ci.ada.fitness.services.DTO.RoutineDTO;
import ci.ada.fitness.services.RoutineService;
import ci.ada.fitness.services.mapper.RoutineMapper;

import ci.ada.fitness.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Slf4j
public class RoutineServiceImpl implements RoutineService {

    private final RoutineMapper routineMapper;
    private final RoutineRepository routineRepository;
    private final UserRepository userRepository;
    private final TrainingProgramRepository trainingProgramRepository;

    @Override
    public RoutineDTO save(RoutineDTO routineDTO) {
        log.debug("Request to save Routine : {}", routineDTO);
        final String slug = SlugifyUtils.generate(("routine-"));
        routineDTO.setSlug(slug);
        Routine routine = routineMapper.toEntity(routineDTO);
        TrainingProgram trainingProgram = trainingProgramRepository.findById(routineDTO.getTrainingProgram().getId()).orElseThrow(() -> new RuntimeException("Training not found"));
        routine.setTrainingProgram(trainingProgram);
        routine = routineRepository.save(routine);
        return routineMapper.toDto(routine);
    }

    @Override
    public RoutineDTO update(RoutineDTO routineDTO) {
        log.debug("Request to update : {}", routineDTO);
        return findOne(routineDTO.getId()).map(existingRoutine -> {
            existingRoutine.setDate(routineDTO.getDate());
            return save(existingRoutine);
        }).orElseThrow(()-> new RuntimeException("Routine not found"));
    }

    @Override
    public RoutineDTO update(RoutineDTO routineDTO, Long id) {
        log.debug("Request to update routine : {}", routineDTO);
        routineDTO.setId(id);
        return update(routineDTO);
    }

    @Override
    public Optional<RoutineDTO> findOne(Long id) {
        log.debug("Request to get routine by id:{}", id);
        return routineRepository.findById(id).map(routineMapper::toDto);
    }

    @Override
    public List<RoutineDTO> findAll() {
        log.debug("Request to get all routines");
        return routineRepository.findAll().stream().map(routineMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete routine: {}", id);
        routineRepository.deleteById(id);
    }

    @Override
    public Optional<RoutineDTO> findById(Long id) {
        log.debug("Request to get routine by id:{}", id);
        return routineRepository.findById(id).map(routineMapper::toDto);
    }

    @Override
    public Optional<RoutineDTO> findBySlug(String slug) {
        log.debug("Request to get Routine by slug: {}", slug);
        return routineRepository.findBySlug(slug).map(routineMapper::toDto)
                .map(routineDTO -> {
                    log.info("Routine found: {}", routineDTO);
                    return routineDTO;
                })
                .or(() -> {
                    log.warn("Routine not found for slug: {}", slug);
                    return Optional.empty();
                });
    }

    @Override
    public RoutineDTO partialUpdate(RoutineDTO routineDTO, Long id) {
        log.debug("Request to partially update routine with id: {}", id);

        return routineRepository.findById(id).map(existingRoutine -> {
                    if (routineDTO.getDate() != null) {
                        existingRoutine.setDate(routineDTO.getDate());
                    }

                    return routineRepository.save(existingRoutine);
                }).map(routineMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Routine not found with id: " + routineDTO.getId()));
    }

}
