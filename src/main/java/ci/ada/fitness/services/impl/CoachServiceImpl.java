package ci.ada.fitness.services.impl;

import ci.ada.fitness.models.Coach;
import ci.ada.fitness.models.Speciality;
import ci.ada.fitness.repositories.CoachRepository;
import ci.ada.fitness.repositories.SpecialityRepository;
import ci.ada.fitness.services.CoachService;
import ci.ada.fitness.services.DTO.CoachDTO;
import ci.ada.fitness.services.mapper.CoachMapper;
import ci.ada.fitness.services.mapping.CoachMapping;
import ci.ada.fitness.utils.SlugifyUtils;
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
        return findOne(coachDTO.getId()).map(existingCoach -> {
            existingCoach.setFirstName(coachDTO.getFirstName());
            existingCoach.setLastName(coachDTO.getLastName());
            existingCoach.setSpeciality(specialityRepository.findById(coachDTO.getSpeciality().getId()).orElseThrow(() -> new RuntimeException("Speciality not found")));
            return save(existingCoach);
        }).orElseThrow(()-> new RuntimeException("Coach not found"));
    }


    @Override
    public CoachDTO update(CoachDTO coachDTO, Long id) {
        coachDTO.setId(id);
        return update(coachDTO);
    }



    @Override
    public Optional<CoachDTO> findOne(Long id) {
        return coachRepository.findById(id).map(coachMapper::toDto);
    }

    @Override
    public List<CoachDTO> findAll() {
        return coachRepository.findAll().stream().map(coachMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete coach: {}", id);
        coachRepository.deleteById(id);
    }

    @Override
    public Optional<CoachDTO> findById(Long id) {
        return coachRepository.findById(id).map(coachMapper::toDto);
    }

    @Override
    public Optional<CoachDTO> findBySlug(String slug) {
        log.debug("Request to get coach by slug:{}", slug);
        return coachRepository.findBySlug(slug).map(coachMapper::toDto);
    }

    @Override
    public CoachDTO partialUpdate(CoachDTO coachDTO, Long id) {
        log.debug("Request to partial update coach with id : {} ", id);
        return coachRepository.findById(id).map(coach -> {
            CoachMapping.partialUpdate(coach, coachDTO);
            return coach;
        }).map(coachRepository::save).map(coachMapper::toDto).orElse(null);
    }
}
