package ci.ada.fitness.services.impl;

import ci.ada.fitness.models.Performance;
import ci.ada.fitness.models.User;
import ci.ada.fitness.repositories.PerformanceRepository;
import ci.ada.fitness.repositories.UserRepository;
import ci.ada.fitness.services.DTO.PerformanceDTO;
import ci.ada.fitness.services.DTO.UserDTO;
import ci.ada.fitness.services.PerformanceService;
import ci.ada.fitness.services.UserService;
import ci.ada.fitness.services.mapper.PerformanceMapper;
import ci.ada.fitness.services.mapper.UserMapper;
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
        return null;
    }

    @Override
    public PerformanceDTO update(PerformanceDTO performanceDTO, Long id) {
        return null;
    }

    @Override
    public Optional<PerformanceDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<PerformanceDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<PerformanceDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<PerformanceDTO> findBySlug(String slug) {
        return Optional.empty();
    }

    @Override
    public PerformanceDTO partialUpdate(PerformanceDTO performanceDTO, Long id) {
        return null;
    }
}
