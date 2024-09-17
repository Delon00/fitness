package ci.ada.fitness.services;

import ci.ada.fitness.services.DTO.PersonalizedAdviceDTO;

import java.util.List;
import java.util.Optional;

public interface PersonalizedAdviceService {

    PersonalizedAdviceDTO save(PersonalizedAdviceDTO personalizedAdviceDTO);

    PersonalizedAdviceDTO update(PersonalizedAdviceDTO personalizedAdviceDTO);

    PersonalizedAdviceDTO update(PersonalizedAdviceDTO personalizedAdviceDTO, Long id);

    Optional<PersonalizedAdviceDTO> findOne(Long id);

    List<PersonalizedAdviceDTO> findAll();

    void delete(Long id);

    Optional<PersonalizedAdviceDTO>findById(Long id);

    Optional<PersonalizedAdviceDTO> findBySlug(String slug);

    PersonalizedAdviceDTO partialUpdate(PersonalizedAdviceDTO personalizedAdviceDTO, Long id);
}
