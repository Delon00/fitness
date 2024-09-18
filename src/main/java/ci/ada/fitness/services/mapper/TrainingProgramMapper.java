package ci.ada.fitness.services.mapper;


import ci.ada.fitness.models.TrainingProgram;
import ci.ada.fitness.services.DTO.TrainingProgramDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface TrainingProgramMapper extends EntityMapper<TrainingProgramDTO, TrainingProgram> {

}
