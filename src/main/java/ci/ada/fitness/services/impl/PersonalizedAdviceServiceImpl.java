package ci.ada.fitness.services.impl;


import ci.ada.fitness.models.PersonalizedAdvice;
import ci.ada.fitness.models.Routine;
import ci.ada.fitness.repositories.PersonalizedAdviceRepository;
import ci.ada.fitness.repositories.RoutineRepository;
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
    private final RoutineRepository routineRepository;

    @Override
    public PersonalizedAdviceDTO save(PersonalizedAdviceDTO personalizedAdviceDTO) {
        log.debug("REST Request to save PersonalizedAdvice : {}", personalizedAdviceDTO);
        final String slug = SlugifyUtils.generate(String.valueOf(personalizedAdviceDTO.getDateAdvice()));
        personalizedAdviceDTO.setSlug(slug);
//        PersonalizedAdvice personalizedAdvice = personalizedAdviceMapper.toEntity(personalizedAdviceDTO);

        Optional<Routine> routine = routineRepository.findById(personalizedAdviceDTO.getRoutine().getId());
        if (routine.isPresent()) {
            PersonalizedAdvice personalizedAdvice = personalizedAdviceMapper.toEntity(personalizedAdviceDTO);
            personalizedAdvice.setRoutine(routine.get());
            log.debug("User after mapping{}", personalizedAdvice);
            personalizedAdvice = personalizedAdviceRepository.save(personalizedAdvice);
            return personalizedAdviceMapper.toDto(personalizedAdvice);
        } else {
            throw new RuntimeException("Routine not found");
        }
//
//        log.debug("User after mapping{}", personalizedAdvice);
//        personalizedAdvice = personalizedAdviceRepository.save(personalizedAdvice);
//        return personalizedAdviceMapper.toDto(personalizedAdvice);
    }

    @Override
    public PersonalizedAdviceDTO update(PersonalizedAdviceDTO personalizedAdviceDTO) {
        log.debug("REST Request to update PersonalizedAdvice : {}", personalizedAdviceDTO);
        return findOne(personalizedAdviceDTO.getId()).map(existingRoutine -> {
            existingRoutine.setSlug(personalizedAdviceDTO.getSlug());
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
                    if (personalizedAdviceDTO.getContent() != null) {
                        existingRoutine.setId(personalizedAdviceDTO.getId());
                    }

                    return personalizedAdviceRepository.save(existingRoutine);
                }).map(personalizedAdviceMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Routine not found with id: " + personalizedAdviceDTO.getId()));
    }

    @Override
    public Optional<PersonalizedAdviceDTO> findBySlug(String slug) {
        log.debug("Request to get PersonalizedAdvice by slug: {}", slug);
        return personalizedAdviceRepository.findBySlug(slug).map(personalizedAdviceMapper::toDto)
               .map(personalizedAdviceDTO -> {
                    log.info("PersonalizedAdvice found: {}", personalizedAdviceDTO);
                    return personalizedAdviceDTO;
                })
                .or(() -> {
                    log.info("PersonalizedAdvice not found by slug: {}", slug);
                    return Optional.empty();
                });
    }
}
