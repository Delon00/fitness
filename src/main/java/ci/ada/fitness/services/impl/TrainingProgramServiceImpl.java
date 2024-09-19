package ci.ada.fitness.services.impl;

import ci.ada.fitness.models.TrainingProgram;
import ci.ada.fitness.models.User;
import ci.ada.fitness.repositories.TrainingProgramRepository;
import ci.ada.fitness.repositories.UserRepository;
import ci.ada.fitness.services.DTO.TrainingProgramDTO;
import ci.ada.fitness.services.DTO.UserDTO;
import ci.ada.fitness.services.TrainingProgramService;
import ci.ada.fitness.services.UserService;
import ci.ada.fitness.services.mapper.TrainingProgramMapper;
import ci.ada.fitness.utils.SlugifyUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrainingProgramServiceImpl implements TrainingProgramService {

    private final TrainingProgramMapper trainingProgramMapper;
    private final TrainingProgramRepository trainingProgramRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public TrainingProgramDTO save(TrainingProgramDTO trainingProgramDTO) {
        log.debug("Request to save trainingProgram: {}", trainingProgramDTO);
        TrainingProgram trainingProgram = trainingProgramMapper.toEntity(trainingProgramDTO);
        User user = userRepository.findById(trainingProgramDTO.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
        trainingProgram.setUser(user);
        trainingProgram = trainingProgramRepository.save(trainingProgram);
        return trainingProgramMapper.toDto(trainingProgram);
    }

    @Override
    public TrainingProgramDTO update(TrainingProgramDTO trainingProgramDTO) {
        return findOne(trainingProgramDTO.getId()).map(existingTrainingProgram -> {
            existingTrainingProgram.setName(trainingProgramDTO.getName());
            existingTrainingProgram.setDescription(trainingProgramDTO.getDescription());
            existingTrainingProgram.setTotalDuration(trainingProgramDTO.getTotalDuration());
            existingTrainingProgram.setLevelRequired(trainingProgramDTO.getLevelRequired());
            existingTrainingProgram.setProgramObjective(trainingProgramDTO.getProgramObjective());
            return save(existingTrainingProgram);
        }).orElseThrow(() -> new RuntimeException("Training not found"));
    }

    @Override
    public TrainingProgramDTO update(TrainingProgramDTO trainingProgramDTO, Long id) {
        trainingProgramDTO.setId(id);
        return update(trainingProgramDTO);
    }

    @Override
    public Optional<TrainingProgramDTO> findOne(Long id) {
        return trainingProgramRepository.findById(id).map(trainingProgramMapper::toDto);
    }

    @Override
    public List<TrainingProgramDTO> findAll() {
        log.debug("Request to get all training program");
        return trainingProgramRepository.findAll().stream().map(trainingProgramMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        trainingProgramRepository.deleteById(id);
    }

    @Override
    public Optional<TrainingProgramDTO> findById(Long id) {
        return trainingProgramRepository.findById(id).map(trainingProgramMapper::toDto);
    }

    @Override
    public Optional<TrainingProgramDTO> findBySlug(String slug) {
        return trainingProgramRepository.findBySlug(slug).map(trainingProgramMapper::toDto)
                .map(trainingProgramDTO -> {
                    log.info("trainingProgram found: {}", trainingProgramDTO);
                    return trainingProgramDTO;
                })
                .or(() -> {
                    log.warn("trainingProgram not found for slug: {}", slug);
                    return Optional.empty();
                });
    }

    @Override
    public TrainingProgramDTO partialUpdate(TrainingProgramDTO trainingProgramDTO, Long id) {
        return trainingProgramRepository.findById(id).map(existingtrainingProgram -> {
                    if (trainingProgramDTO.getName() != null) {
                        existingtrainingProgram.setName(trainingProgramDTO.getName());
                    }
                    if (trainingProgramDTO.getDescription() != null) {
                        existingtrainingProgram.setDescription(trainingProgramDTO.getDescription());
                    }
                    if (trainingProgramDTO.getTotalDuration() != null) {
                        existingtrainingProgram.setTotalDuration(trainingProgramDTO.getTotalDuration());
                    }
                    if (trainingProgramDTO.getLevelRequired() != null) {
                        existingtrainingProgram.setLevelRequired(trainingProgramDTO.getLevelRequired());
                    }

                    return trainingProgramRepository.save(existingtrainingProgram);
                }).map(trainingProgramMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("trainingProgram not found with id: " + id));
    }

}
