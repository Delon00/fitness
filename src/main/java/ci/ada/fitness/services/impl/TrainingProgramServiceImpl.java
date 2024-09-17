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
        final String slug = SlugifyUtils.generate(String.valueOf(trainingProgramDTO.getLevelRequired()));
        trainingProgramDTO.setSlug(slug);
        TrainingProgram trainingProgram = trainingProgramMapper.toEntity(trainingProgramDTO);
//        Optional<UserDTO> user = userService.findOne(trainingProgramDTO.getUser().getId());
        User user = userRepository.findById(trainingProgramDTO.getUser().getId()).orElseThrow(() -> new RuntimeException("Forum not found"));
        trainingProgram.setUser(user);
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
        log.debug("Request to get all training program");
        return trainingProgramRepository.findAll().stream().map(trainingProgramMapper::toDto).toList();
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
