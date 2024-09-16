package ci.ada.fitness.services.mapper;
import ci.ada.fitness.models.User;
import ci.ada.fitness.services.DTO.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User>{
}
