package ci.ada.fitness.web.resources;


import ci.ada.fitness.services.DTO.ExerciseDTO;
import ci.ada.fitness.services.ExerciseService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exercises")
@Slf4j
@RequiredArgsConstructor
public class ExerciseResource {

    private final ExerciseService exerciseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ExerciseDTO> createExercise(@RequestBody  ExerciseDTO exerciseDTO){
        return null;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getExerciseById(@PathVariable Long id){
        return null;
    }

    @GetMapping("/slug/{slug}")
    @ResponseStatus(HttpStatus.OK)

    public ResponseEntity<?> getExerciseBySlug(@PathVariable String slug) {
        log.info("REST Request to get Exercise by slug: {}", slug);
        return null;
    }

    @GetMapping
    @ApiResponse(responseCode = "201", description = "List of exercises")
    public List<ExerciseDTO> getAllExercise(){
        log.debug("REST Request to all exercise ");
        return null;
    }



    @PutMapping("/{id}")
    public ResponseEntity<ExerciseDTO> updateExercise(@PathVariable Long id, @RequestBody ExerciseDTO exerciseDTO) {
        log.debug("REST request to update exercise with id: {}", id);

        return null;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ExerciseDTO> partialUpdateExercise(@PathVariable Long id, @RequestBody ExerciseDTO exerciseDTO) {
        log.debug("REST request to partially update exercise with id: {}", id);
        return null;
    }




    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "201", description = "Request to delete")
    public void deleteExercise(@PathVariable Long id){

    }

}
