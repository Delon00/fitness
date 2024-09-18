package ci.ada.fitness.services.impl;

import ci.ada.fitness.models.PersonalizedAdvice;
import ci.ada.fitness.models.Routine;
import ci.ada.fitness.repositories.PersonalizedAdviceRepository;
import ci.ada.fitness.services.DTO.PersonalizedAdviceDTO;
import ci.ada.fitness.services.PersonalizedAdviceService;
import ci.ada.fitness.services.mapper.PersonalizedAdviceMapper;
import ci.ada.fitness.services.mapping.ExerciseMapping;
import ci.ada.fitness.services.mapping.PerformanceMapping;
import ci.ada.fitness.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Slf4j
public class PersonalizedAdviceServiceImpl implements PersonalizedAdviceService {
    private final PersonalizedAdviceMapper personalizedAdviceMapper;
    private final PersonalizedAdviceRepository personalizedAdviceRepository;

    @Override
    public PersonalizedAdviceDTO save(PersonalizedAdviceDTO personalizedAdviceDTO) {
        log.debug("Request to save PersonalizedAdvice : {}", personalizedAdviceDTO);
        final String slug = SlugifyUtils.generate(personalizedAdviceDTO.getAdvice());
        personalizedAdviceDTO.setSlug(slug);
        PersonalizedAdvice personalizedAdvice = personalizedAdviceMapper.toEntity(personalizedAdviceDTO);
        personalizedAdvice = personalizedAdviceRepository.save(personalizedAdvice);
        return personalizedAdviceMapper.toDto(personalizedAdvice);
    }

    @Override
    public PersonalizedAdviceDTO update(PersonalizedAdviceDTO personalizedAdviceDTO) {
        return findOne(personalizedAdviceDTO.getId()).map(existingAdvice -> {
            existingAdvice.setDate(personalizedAdviceDTO.getDate());
            return save(existingAdvice);
        }).orElseThrow(()-> new RuntimeException("Advice not found"));
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
        log.debug("Request to partialUpdate PersonalizedAdvice : {}", id);
        return personalizedAdviceRepository.findById(id).map(existingPersonalizedAdvice ->{
            if (personalizedAdviceDTO.getAdvice()!=null) {
                existingPersonalizedAdvice.setAdvice(personalizedAdviceDTO.getAdvice());
            }
            return personalizedAdviceRepository.save(existingPersonalizedAdvice);
        }).map(personalizedAdviceMapper::toDto)
                .orElseThrow(()-> new RuntimeException("Advice not found with id "+ personalizedAdviceDTO.getId()));
    }

}
