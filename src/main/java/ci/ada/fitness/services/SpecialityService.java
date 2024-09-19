package ci.ada.fitness.services;

import ci.ada.fitness.services.DTO.SpecialityDTO;

import java.util.List;
import java.util.Optional;

public interface SpecialityService {

    SpecialityDTO save(SpecialityDTO specialityDTO);

    SpecialityDTO update(SpecialityDTO specialityDTO);

    SpecialityDTO update(SpecialityDTO specialityDTO, Long id);

    Optional<SpecialityDTO> findOne(Long id);

    List<SpecialityDTO> findAll();

    void delete(Long id);

    Optional<SpecialityDTO>findById(Long id);

    Optional<SpecialityDTO> findBySlug(String slug);


}
