package ci.ada.fitness.services;

import ci.ada.fitness.services.DTO.RoutineDTO;

import java.util.List;
import java.util.Optional;

public interface RoutineService {

    RoutineDTO save(RoutineDTO routineDTO);

    RoutineDTO update(RoutineDTO routineDTO);

    RoutineDTO update(RoutineDTO routineDTO, Long id);

    Optional<RoutineDTO> findOne(Long id);

    List<RoutineDTO> findAll();

    void delete(Long id);

    Optional<RoutineDTO>findById(Long id);

    Optional<RoutineDTO> findBySlug(String slug);

    RoutineDTO partialUpdate(RoutineDTO routineDTO, Long id);

//    Optional<>
}
