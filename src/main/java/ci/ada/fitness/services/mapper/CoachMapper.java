package ci.ada.fitness.services.mapper;

import ci.ada.fitness.models.Coach;
import ci.ada.fitness.services.DTO.CoachDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoachMapper extends EntityMapper<CoachDTO, Coach>  {
}
