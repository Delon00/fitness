package ci.ada.fitness.services.mapper;

import ci.ada.fitness.models.User;
import ci.ada.fitness.services.DTO.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface UserMapper extends EntityMapper<UserDTO, User>  {
}
