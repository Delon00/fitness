package ci.ada.fitness.services.Impl;

import ci.ada.fitness.services.DTO.UserDTO;
import ci.ada.fitness.services.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public UserDTO save(UserDTO userDTO) {
        return null;
    }

    @Override
    public Optional<UserDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> findOneUserBySlug(String slug) {
        return Optional.empty();
    }

    @Override
    public List<UserDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
