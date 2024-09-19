package ci.ada.fitness.services;

import ci.ada.fitness.services.DTO.CoachDTO;

import java.util.List;
import java.util.Optional;

public interface CoachService {

    CoachDTO save(CoachDTO coachDTO);

    CoachDTO update(CoachDTO coachDTO);

    CoachDTO update(CoachDTO coachDTO, Long id);

    Optional<CoachDTO> findOne(Long id);

    List<CoachDTO> findAll();

    void delete(Long id);

    Optional<CoachDTO>findById(Long id);

    Optional<CoachDTO> findBySlug(String slug);


    CoachDTO partialUpdate(CoachDTO coachDTO, Long id);
}
