package ci.ada.fitness.services.impl;

import ci.ada.fitness.models.User;
import ci.ada.fitness.repositories.UserRepository;
import ci.ada.fitness.services.DTO.UserDTO;
import ci.ada.fitness.services.UserService;
import ci.ada.fitness.services.mapper.UserMapper;
import ci.ada.fitness.services.mapping.UserMapping;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserDTO save(UserDTO userDTO) {
        log.debug("Request to save user: {}", userDTO);
        User user = userMapper.toEntity(userDTO);
        log.debug("User after mapping{}", user);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return findOne(userDTO.getId()).map(existingUser -> {
            existingUser.setBirthday(userDTO.getBirthday());
            existingUser.setEmail(userDTO.getEmail());
            return save(existingUser);
        }).orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public UserDTO update(UserDTO userDTO, Long id) {
        userDTO.setId(id);
        return update(userDTO);
    }

    @Override
    public Optional<UserDTO> findOne(Long id) {
        return userRepository.findById(id).map(userMapper::toDto);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete user: {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        return userRepository.findById(id).map(userMapper::toDto);
    }

    @Override
    public Optional<UserDTO> findBySlug(String slug) {
        log.debug("Request to get user by slug:{}", slug);
        return userRepository.findBySlug(slug).map(userMapper::toDto);
    }

    @Override
    public UserDTO partialUpdate(UserDTO userDTO, Long id) {
        log.debug("Request to partial update user with id : {} ", id);
        return userRepository.findById(id).map(user -> {
            UserMapping.partialUpdate(user, userDTO);
            return user;
        }).map(userRepository::save).map(userMapper::toDto).orElse(null);
    }
}
