package ci.ada.fitness.services.impl;

import ci.ada.fitness.models.Coach;
import ci.ada.fitness.models.Speciality;
import ci.ada.fitness.repositories.CoachRepository;
import ci.ada.fitness.repositories.SpecialityRepository;
import ci.ada.fitness.services.CoachService;
import ci.ada.fitness.services.DTO.CoachDTO;
import ci.ada.fitness.services.mapper.CoachMapper;
import ci.ada.fitness.utils.SlugifyUtils;
import jakarta.persistence.OneToOne;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;
    private final CoachMapper coachMapper;
    private final SpecialityRepository specialityRepository;


    @Override
    public CoachDTO save(CoachDTO coachDTO) {
        log.debug("REST Request to save Coach : {}", coachDTO);
        final String slug = SlugifyUtils.generate(String.valueOf("coach-"));
        coachDTO.setSlug(slug);

        Coach coach = coachMapper.toEntity(coachDTO);
        Speciality speciality = specialityRepository.findById(coachDTO.getSpeciality().getId()).orElseThrow(() -> new RuntimeException("Forum not found"));
        coach.setSpeciality(speciality);
        coach = coachRepository.save(coach);
        return coachMapper.toDto(coach);
    }

    @Override
    public CoachDTO update(CoachDTO coachDTO) {
        log.debug("REST Request to update Coach : {}", coachDTO);
        return null;
    }

    @Override
    public CoachDTO update(CoachDTO coachDTO, Long id) {
        return null;
    }

    @Override
    public Optional<CoachDTO> findOne(Long id) {
        log.debug("Request to get Coach by id:{}", id);
        return Optional.empty();
    }

    @Override
    public List<CoachDTO> findAll() {
        log.debug("Request to get all Coaches");
        return List.of();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Coach: {}", id);
        coachRepository.deleteById(id);

    }

    @Override
    public Optional<CoachDTO> findById(Long id) {
        log.debug("Request to get Coach by id:{}", id);
        return Optional.empty();
    }

    @Override
    public Optional<CoachDTO> findBySlug(String slug) {
        log.debug("Request to get Coach by slug:{}", slug);
        return Optional.empty();
    }
}
