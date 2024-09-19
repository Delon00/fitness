package ci.ada.fitness.services.impl;

import ci.ada.fitness.services.CoachService;
import ci.ada.fitness.services.DTO.CoachDTO;

import java.util.List;
import java.util.Optional;

public class CoachServiceImpl implements CoachService {
    @Override
    public CoachDTO save(CoachDTO coachDTO) {
        return null;
    }

    @Override
    public CoachDTO update(CoachDTO coachDTO) {
        return null;
    }

    @Override
    public CoachDTO update(CoachDTO coachDTO, Long id) {
        return null;
    }

    @Override
    public Optional<CoachDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<CoachDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<CoachDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CoachDTO> findBySlug(String slug) {
        return Optional.empty();
    }
}
