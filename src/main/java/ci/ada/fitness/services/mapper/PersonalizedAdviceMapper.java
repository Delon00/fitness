package ci.ada.fitness.services.mapper;

import ci.ada.fitness.services.DTO.PersonalizedAdviceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonalizedAdviceMapper extends EntityMapper<PersonalizedAdviceDTO, PersonalizedAdviceMapper>{
}
