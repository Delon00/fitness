package ci.ada.fitness.services.mapper;

import ci.ada.fitness.models.Routine;
import ci.ada.fitness.services.DTO.RoutineDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoutineMapper extends EntityMapper<RoutineDTO, Routine>{
}
