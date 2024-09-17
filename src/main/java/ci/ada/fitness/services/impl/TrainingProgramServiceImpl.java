package ci.ada.fitness.services.impl;

import ci.ada.fitness.models.TrainingProgram;
import ci.ada.fitness.repositories.TrainingProgramRepository;
import ci.ada.fitness.services.DTO.TrainingProgramDTO;
import ci.ada.fitness.services.DTO.UserDTO;
import ci.ada.fitness.services.TrainingProgramService;
import ci.ada.fitness.services.UserService;
import ci.ada.fitness.services.mapper.TrainingProgramMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrainingProgramServiceImpl implements TrainingProgramService {

    private final TrainingProgramMapper trainingProgramMapper;;
    private final TrainingProgramRepository trainingProgramRepository;
    private final UserService userService;

    @Override
    public TrainingProgramDTO save(TrainingProgramDTO trainingProgramDTO) {
        log.debug("Request to save trainingProgram: {}", trainingProgramDTO);
        Optional<UserDTO> users = userService.findOne(trainingProgramDTO.getId());
        TrainingProgram trainingProgram = trainingProgramMapper.toEntity(trainingProgramDTO);
        trainingProgram = trainingProgramRepository.save(trainingProgram);
        return trainingProgramMapper.toDto(trainingProgram);
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
