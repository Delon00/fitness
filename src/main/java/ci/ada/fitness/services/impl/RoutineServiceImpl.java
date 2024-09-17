package ci.ada.fitness.services.impl;

import ci.ada.fitness.services.DTO.RoutineDTO;
import ci.ada.fitness.services.RoutineService;

import java.util.List;
import java.util.Optional;

public class RoutineServiceImpl implements RoutineService {
    @Override
    public RoutineDTO save(RoutineDTO routineDTO) {
        return null;
    }

    @Override
    public RoutineDTO update(RoutineDTO routineDTO) {
        return null;
    }

    @Override
    public RoutineDTO update(RoutineDTO routineDTO, Long id) {
        return null;
    }

    @Override
    public Optional<RoutineDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<RoutineDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<RoutineDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<RoutineDTO> findBySlug(String slug) {
        return Optional.empty();
    }

    @Override
    public RoutineDTO partialUpdate(RoutineDTO routineDTO, Long id) {
        return null;
    }
}
