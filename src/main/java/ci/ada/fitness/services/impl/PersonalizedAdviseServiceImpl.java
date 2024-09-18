package ci.ada.fitness.services.impl;

import ci.ada.fitness.models.PersonalizedAdvice;
import ci.ada.fitness.models.User;
import ci.ada.fitness.repositories.PersonalizedAdviceRepository;
import ci.ada.fitness.repositories.UserRepository;
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
public class PersonalizedAdviseServiceImpl implements PersonalizedAdviceService {

    private final PersonalizedAdviceRepository personalizedAdviceRepository;
    private final PersonalizedAdviceMapper personalizedAdviceMapper;
    private final UserRepository userRepository;

    @Override
    public PersonalizedAdviceDTO save(PersonalizedAdviceDTO personalizedAdviceDTO) {
        log.debug("Request to save personalized advice : {}", personalizedAdviceDTO);
        final String slug = SlugifyUtils.generate(String.valueOf(personalizedAdviceDTO.getSlug()));
        personalizedAdviceDTO.setSlug(slug);
        PersonalizedAdvice personalizedAdvice = personalizedAdviceMapper.toEntity(personalizedAdviceDTO);
        User user = userRepository.findById(personalizedAdviceDTO.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
        personalizedAdvice.setUser(user);
        log.debug("PersonalizedAdvice after mapping{}", personalizedAdvice);
        personalizedAdvice = personalizedAdviceRepository.save(personalizedAdvice);
        return personalizedAdviceMapper.toDto(personalizedAdvice);
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
