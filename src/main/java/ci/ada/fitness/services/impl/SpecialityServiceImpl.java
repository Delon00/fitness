package ci.ada.fitness.services.impl;

import ci.ada.fitness.models.Speciality;
import ci.ada.fitness.models.User;
import ci.ada.fitness.repositories.SpecialityRepository;
import ci.ada.fitness.services.DTO.SpecialityDTO;
import ci.ada.fitness.services.SpecialityService;
import ci.ada.fitness.services.mapper.SpecialityMapper;
import ci.ada.fitness.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityMapper specialityMapper;
    private final SpecialityRepository specialityRepository;

    @Override
    public SpecialityDTO save(SpecialityDTO specialityDTO) {
        log.debug("Request to save speciality: {}", specialityDTO);
        final String slug = SlugifyUtils.generate(String.valueOf("speciality"));
        specialityDTO.setSlug(slug);
        Speciality speciality = specialityMapper.toEntity(specialityDTO);
        log.debug("User after mapping{}", speciality);
        speciality = specialityRepository.save(speciality);
        return specialityMapper.toDto(speciality);
    }

    @Override
    public SpecialityDTO update(SpecialityDTO specialityDTO) {
        return findOne(specialityDTO.getId()).map(existingSpeciality -> {
            existingSpeciality.setName(specialityDTO.getName());
            return save(existingSpeciality);
        }).orElseThrow(()-> new RuntimeException("Speciality not found"));
    }

    @Override
    public SpecialityDTO update(SpecialityDTO specialityDTO, Long id) {
        log.debug("Request to update a speciality : {} {}", specialityDTO, id);
        specialityDTO.setId(id);
        return update(specialityDTO);
    }

    @Override
    public Optional<SpecialityDTO> findOne(Long id) {
        log.debug("Request to get speciality by id : {}", id);
        return specialityRepository.findById(id).map(specialityMapper::toDto);
    }

    @Override
    public List<SpecialityDTO> findAll() {
        log.debug("Request to get all specialities");
        return specialityRepository.findAll().stream().map(specialityMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete speciality : {}", id);
        specialityRepository.deleteById(id);
    }

    @Override
    public Optional<SpecialityDTO> findById(Long id) {
        log.debug("Request to get speciality by id : {}", id);
        return specialityRepository.findById(id).map(specialityMapper::toDto);
    }

    @Override
    public Optional<SpecialityDTO> findBySlug(String slug) {
        log.debug("Request to get speciality by slug : {}", slug);
        return specialityRepository.findBySlug(slug).map(specialityMapper::toDto);
    }
}
