package ci.ada.fitness.services.impl;


import ci.ada.fitness.models.PersonalizedAdvice;
import ci.ada.fitness.repositories.PersonalizedAdviceRepository;
import ci.ada.fitness.services.DTO.PersonalizedAdviceDTO;
import ci.ada.fitness.services.PersonalizedAdviceService;
import ci.ada.fitness.services.mapper.PersonalizedAdviceMapper;
import ci.ada.fitness.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonalizedAdviceServiceImpl implements PersonalizedAdviceService {
    private final PersonalizedAdviceMapper personalizedAdviceMapper;
    private final PersonalizedAdviceRepository personalizedAdviceRepository;
    @Override
    public PersonalizedAdviceDTO save(PersonalizedAdviceDTO personalizedAdviceDTO) {
        log.debug("REST Request to save PersonalizedAdvice : {}", personalizedAdviceDTO);
        final String slug = SlugifyUtils.generate(String.valueOf(personalizedAdviceDTO.getAdvice()));
        personalizedAdviceDTO.setSlug(slug);
        PersonalizedAdvice personalizedAdvice = personalizedAdviceMapper.toEntity(personalizedAdviceDTO);
        log.debug("User after mapping{}", personalizedAdvice);
        personalizedAdvice = personalizedAdviceRepository.save(personalizedAdvice);
        return personalizedAdviceMapper.toDto(personalizedAdvice);
    }

    @Override
    public PersonalizedAdviceDTO update(PersonalizedAdviceDTO personalizedAdviceDTO) {
        log.debug("REST Request to update PersonalizedAdvice : {}", personalizedAdviceDTO);
        return findOne(personalizedAdviceDTO.getId()).map(existingRoutine -> {
            existingRoutine.setDate(personalizedAdviceDTO.getDate());
            return save(existingRoutine);
        }).orElseThrow(()-> new RuntimeException("PersonalizedAdvice not found"));
    }

    @Override
    public PersonalizedAdviceDTO update(PersonalizedAdviceDTO personalizedAdviceDTO, Long id) {
        log.debug("REST Request to update PersonalizedAdvice : {}", personalizedAdviceDTO);
        personalizedAdviceDTO.setId(id);
        return update(personalizedAdviceDTO);
    }

    @Override
    public Optional<PersonalizedAdviceDTO> findOne(Long id) {
        log.debug("REST Request to get PersonalizedAdvice : {}", id);
        return personalizedAdviceRepository.findById(id).map(personalizedAdviceMapper::toDto);
    }

    @Override
    public List<PersonalizedAdviceDTO> findAll() {
        log.debug("REST Request to get all PersonalizedAdvices");
        return personalizedAdviceRepository.findAll().stream().map(personalizedAdviceMapper::toDto).toList();

    }

    @Override
    public void delete(Long id) {
        log.debug("REST Request to delete PersonalizedAdvice : {}", id);
        personalizedAdviceRepository.deleteById(id);

    }

    @Override
    public Optional<PersonalizedAdviceDTO> findById(Long id) {
        log.debug("REST Request to findById PersonalizedAdvice : {}", id);
        return personalizedAdviceRepository.findById(id).map(personalizedAdviceMapper::toDto);
    }


    @Override
    public PersonalizedAdviceDTO partialUpdate(PersonalizedAdviceDTO personalizedAdviceDTO, Long id) {
        log.debug("REST Request to partialUpdate PersonalizedAdvice : {}", personalizedAdviceDTO);
        return personalizedAdviceRepository.findById(id).map(existingRoutine -> {
                    if (personalizedAdviceDTO.getDate() != null) {
                        existingRoutine.setId(personalizedAdviceDTO.getId());
                    }

                    return personalizedAdviceRepository.save(existingRoutine);
                }).map(personalizedAdviceMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Routine not found with id: " + personalizedAdviceDTO.getId()));
    }
}
