package ci.ada.fitness.services.impl;

import ci.ada.fitness.services.DTO.PersonalizedAdviceDTO;
import ci.ada.fitness.services.PersonalizedAdviceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonalizedAdviceServiceImpl implements PersonalizedAdviceService {
    @Override
    public PersonalizedAdviceDTO save(PersonalizedAdviceDTO personalizedAdviceDTO) {
        return null;
    }

    @Override
    public PersonalizedAdviceDTO update(PersonalizedAdviceDTO personalizedAdviceDTO) {
        return null;
    }

    @Override
    public PersonalizedAdviceDTO update(PersonalizedAdviceDTO personalizedAdviceDTO, Long id) {
        return null;
    }

    @Override
    public Optional<PersonalizedAdviceDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<PersonalizedAdviceDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<PersonalizedAdviceDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<PersonalizedAdviceDTO> findBySlug(String slug) {
        return Optional.empty();
    }

    @Override
    public PersonalizedAdviceDTO partialUpdate(PersonalizedAdviceDTO personalizedAdviceDTO, Long id) {
        return null;
    }
}
