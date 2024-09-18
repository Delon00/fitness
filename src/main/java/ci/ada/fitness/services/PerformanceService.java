package ci.ada.fitness.services;

import ci.ada.fitness.services.DTO.PerformanceDTO;

import java.util.List;
import java.util.Optional;

public interface PerformanceService {

    PerformanceDTO save(PerformanceDTO performanceDTO);

    PerformanceDTO update(PerformanceDTO performanceDTO);

    PerformanceDTO update(PerformanceDTO performanceDTO, Long id);

    Optional<PerformanceDTO> findOne(Long id);

    List<PerformanceDTO> findAll();

    void delete(Long id);

    Optional<PerformanceDTO>findById(Long id);

    Optional<PerformanceDTO> findBySlug(String slug);

    PerformanceDTO partialUpdate(PerformanceDTO performanceDTO, Long id);
}
