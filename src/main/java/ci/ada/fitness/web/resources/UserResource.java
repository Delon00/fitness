package ci.ada.fitness.web.resources;


import ci.ada.fitness.services.DTO.UserDTO;
import ci.ada.fitness.services.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Slf4j
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDTO> createUser(@RequestBody  UserDTO userDTO){
        log.debug("REST Request to save  {}", userDTO);
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        log.debug(" REST Request to get one  ");
        Optional<UserDTO> userDTO = userService.findOne(id);
        if (userDTO.isPresent()) {
            return new ResponseEntity<>(userDTO.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/slug/{slug}")
    @ResponseStatus(HttpStatus.OK)

    public ResponseEntity<?> getUserBySlug(@PathVariable String slug) {
        log.info("REST Request to get User by slug: {}", slug);
        Optional<UserDTO> forumDTO = userService.findOneUserBySlug(slug);

        if (forumDTO.isPresent()) {
            return new ResponseEntity<>(forumDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User by slug not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @ApiResponse(responseCode = "201", description = "List of users")
    public List<UserDTO> getAllUser(){
        log.debug("REST Request to all user ");
        return userService.findAll();
    }



    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        log.debug("REST request to update user with id: {}", id);

        Optional<UserDTO> existingUser = userService.findOne(id);
        if (!existingUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userDTO.setId(id);
        UserDTO updatedUser = userService.save(userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDTO> partialUpdateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        log.debug("REST request to partially update user with id: {}", id);

        Optional<UserDTO> existingUser = userService.findOne(id);
        if (!existingUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        UserDTO currentUser = existingUser.get();

        if (userDTO.getNom() != null) {
            currentUser.setNom(userDTO.getNom());
        }
        if (userDTO.getAge() != null) {
            currentUser.setAge(userDTO.getAge());
        }
        if (userDTO.getEmail() != null) {
            currentUser.setEmail(userDTO.getEmail());
        }

        UserDTO updatedUser = userService.save(currentUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }




    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "201", description = "Request to delete")
    public void deleteUser(@PathVariable Long id){
        log.debug("REST Request to delete  ");
        userService.delete(id);
    }

   /* @PostMapping("register-user")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody RegistrationUserDTO registrationUserDTO){
        log.debug("REST request to");
        userService.registerUser(registrationUserDTO);
    }*/
}
