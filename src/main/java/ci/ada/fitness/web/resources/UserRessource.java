package ci.ada.fitness.web.resources;

import ci.ada.fitness.services.DTO.UserDTO;
import ci.ada.fitness.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/users")
public class UserRessource {

    private final UserService userService;


    @PostMapping
    @ApiResponse(responseCode = "200", description = "Request to save User")
    @Operation(summary = "save new user", description = "this endpoint allow to save user")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user) {
        log.debug("REST request to save user {}", user);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "201", description = "Request to update User")
    public UserDTO updateUser(@RequestBody UserDTO user, @PathVariable Long id) {
        log.debug("REST request to update user {}", user);
        return userService.update(user, id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to delete User")
    public void deleteUser(@PathVariable Long id) {
        log.debug("REST request to delete user {}", id);
        userService.delete(id);
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to get User")
    public ResponseEntity<?> getUser(
            @Parameter(required = true, description = "ID of user to be retrieved")
            @PathVariable Long id
    ) {
        log.debug("REST request to get user {}", id);

        Optional<UserDTO> user = userService.findById(id);

        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }


    @GetMapping
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "Request to get Users"),
                    @ApiResponse(responseCode = "404", description = "Users not found", content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public List<UserDTO> getUsers() {
        log.debug("REST request to get users");
        return userService.findAll();
    }


    @GetMapping("/slug/{slug}")
    @ApiResponse(responseCode = "200", description = "Return a user by its slug")
    @Operation(summary = "Find a user by its slug", description = "This endpoint allows to find a user by its slug")
    public ResponseEntity<UserDTO> findUserBySlug(
            @Parameter(required = true, description = "Slug of the user to be retrieved")
            @PathVariable String slug
    ) {
        log.debug("REST request to get User by slug : {}", slug);
        Optional<UserDTO> user = userService.findBySlug(slug);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}