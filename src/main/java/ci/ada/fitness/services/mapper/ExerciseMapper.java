package ci.ada.fitness.services.mapper;

import ci.ada.fitness.models.Exercise;
import ci.ada.fitness.services.DTO.ExerciseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExerciseMapper extends EntityMapper<ExerciseDTO, Exercise> {
    List<Exercise> toExerciseList(List<ExerciseDTO> exerciseDTOs);
}