package ci.ada.fitness.services;

import ci.ada.fitness.services.DTO.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO save(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    UserDTO update(UserDTO userDTO, Long id);

    Optional<UserDTO> findOne(Long id);

    List<UserDTO> findAll();

    void delete(Long id);

    Optional<UserDTO>findById(Long id);

    Optional<UserDTO> findBySlug(String slug);

    UserDTO partialUpdate(UserDTO userDTO, Long id);
}
