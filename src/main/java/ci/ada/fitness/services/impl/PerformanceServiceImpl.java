package ci.ada.fitness.services.impl;

import ci.ada.fitness.models.Performance;
import ci.ada.fitness.models.TrainingProgram;
import ci.ada.fitness.models.User;
import ci.ada.fitness.repositories.PerformanceRepository;
import ci.ada.fitness.repositories.UserRepository;
import ci.ada.fitness.services.DTO.PerformanceDTO;
import ci.ada.fitness.services.DTO.UserDTO;
import ci.ada.fitness.services.PerformanceService;
import ci.ada.fitness.services.UserService;
import ci.ada.fitness.services.mapper.PerformanceMapper;
import ci.ada.fitness.services.mapper.UserMapper;
import ci.ada.fitness.services.mapping.ExerciseMapping;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PerformanceServiceImpl implements PerformanceService {

    private final PerformanceMapper performanceMapper;
    private final PerformanceRepository performanceRepository;
    private final UserService userService;

    @Override
    public PerformanceDTO save(PerformanceDTO performanceDTO) {
        log.debug("Request to save performance: {}", performanceDTO);
        Optional<UserDTO> user = userService.findOne(performanceDTO.getId());
        if (user.isPresent()) {
            performanceDTO.setUser(user.get());
        }
        performanceDTO.getUser().setPerformances(null);
        Performance performance = performanceMapper.toEntity(performanceDTO);
        performance = performanceRepository.save(performance);
        return performanceMapper.toDto(performance);
    }

    @Override
    public PerformanceDTO update(PerformanceDTO performanceDTO) {
        log.debug("REST to update performance: {}", performanceDTO);
        return findOne(performanceDTO.getId()).map(existingPerformance -> {
            existingPerformance.setDate(performanceDTO.getDate());
            return save(existingPerformance);
        }).orElseThrow(()-> new RuntimeException("performance not found"));
    }

    @Override
    public PerformanceDTO update(PerformanceDTO performanceDTO, Long id) {
        log.debug("REST Request to update performance: {}", performanceDTO);
        performanceDTO.setId(id);
        return update(performanceDTO);
    }

    @Override
    public Optional<PerformanceDTO> findOne(Long id) {
        log.debug("REST Request to found performance: {}", id);
        return performanceRepository.findById(id).map(performance -> {
            return performanceMapper.toDto(performance);
        });
    }

    @Override
    public List<PerformanceDTO> findAll() {
        log.debug("REST Request to found all performance: {} ", performanceRepository.findAll());
        return performanceRepository.findAll().stream().map(performanceMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("REST Request to delete performance: {}", id);
        performanceRepository.deleteById(id);

    }

    @Override
    public Optional<PerformanceDTO> findById(Long id) {
        log.debug("REST Request to get performance: {}", id);
        return performanceRepository.findById(id).map(performanceMapper::toDto);
    }

    @Override
    public Optional<PerformanceDTO> findBySlug(String slug) {
        log.debug("REST Request to get performance: {}", slug);
        return performanceRepository.findBySlug(slug).map(performance ->{
            return performanceMapper.toDto(performance);
        });
    }

    @Override
    public PerformanceDTO partialUpdate(PerformanceDTO performanceDTO, Long id) {
        log.debug("Request to partial update performance: {}", performanceDTO);
        return performanceRepository.findById(id).map(existingPerformance -> {
                    if (performanceDTO.getDate() != null) {
                        existingPerformance.setDate(performanceDTO.getDate());
                    }
                    return performanceRepository.save(existingPerformance);

                }).map(performanceMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Performance not found with id: " + performanceDTO.getId()));
    }
}
