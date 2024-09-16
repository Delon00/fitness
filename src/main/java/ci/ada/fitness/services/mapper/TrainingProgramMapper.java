package ci.ada.fitness.services.mapper;


import ci.ada.fitness.models.TrainingProgram;
import ci.ada.fitness.services.DTO.TrainingProgramDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingProgramMapper extends EntityMapper<TrainingProgramDTO, TrainingProgram>{
}
