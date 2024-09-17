package ci.ada.fitness.services.impl;

import ci.ada.fitness.services.DTO.ExerciseDTO;
import ci.ada.fitness.services.ExerciseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExerciseServiceImpl implements ExerciseService {
    @Override
    public ExerciseDTO save(ExerciseDTO exerciseDTO) {
        return null;
    }

    @Override
    public ExerciseDTO update(ExerciseDTO exerciseDTO) {
        return null;
    }

    @Override
    public ExerciseDTO update(ExerciseDTO exerciseDTO, Long id) {
        return null;
    }

    @Override
    public Optional<ExerciseDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ExerciseDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<ExerciseDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ExerciseDTO> findBySlug(String slug) {
        return Optional.empty();
    }

    @Override
    public ExerciseDTO partialUpdate(ExerciseDTO exerciseDTO, Long id) {
        return null;
    }
}
