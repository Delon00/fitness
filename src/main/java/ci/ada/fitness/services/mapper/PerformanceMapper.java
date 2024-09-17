package ci.ada.fitness.services.mapper;

import ci.ada.fitness.models.Performance;
import ci.ada.fitness.services.DTO.PerformanceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PerformanceMapper extends EntityMapper<PerformanceDTO, Performance>{
}
