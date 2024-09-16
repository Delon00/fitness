package ci.ada.fitness.services;

import ci.ada.fitness.services.DTO.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO save(UserDTO userDTO);

    Optional<UserDTO> findOne(Long id);

    Optional<UserDTO> findOneUserBySlug(String slug);

    List<UserDTO> findAll();

    void delete(Long id);
}
