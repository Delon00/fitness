package ci.ada.fitness.web.resources;

import ci.ada.fitness.services.DTO.ExerciseDTO;
import ci.ada.fitness.services.ExerciseService;
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
@RequestMapping("api/exercises")
public class ExerciseRessource {

    private final ExerciseService exerciseService;


    @PostMapping
    @ApiResponse(responseCode = "200", description = "Request to save Exercise")
    @Operation(summary = "save new exercise", description = "this endpoint allow to save exercise")
    public ResponseEntity<ExerciseDTO> saveExercise(@RequestBody ExerciseDTO exercise) {
        log.debug("REST request to save exercise {}", exercise);
        return new ResponseEntity<>(exerciseService.save(exercise), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "201", description = "Request to update Exercise")
    public ExerciseDTO updateExercise(@RequestBody ExerciseDTO exercise, @PathVariable Long id) {
        log.debug("REST request to update exercise {}", exercise);
        return exerciseService.update(exercise, id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to delete Exercise")
    public void deleteExercise(@PathVariable Long id) {
        log.debug("REST request to delete exercise {}", id);
        exerciseService.delete(id);
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to get Exercise")
    public ResponseEntity<?> getExercise(
            @Parameter(required = true, description = "ID of exercise to be retrieved")
            @PathVariable Long id
    ) {
        log.debug("REST request to get exercise {}", id);

        Optional<ExerciseDTO> exercise = exerciseService.findById(id);

        if (exercise.isPresent()) {
            return new ResponseEntity<>(exercise.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Exercise not found", HttpStatus.NOT_FOUND);
    }


    @GetMapping
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "Request to get Exercises"),
                    @ApiResponse(responseCode = "404", description = "Exercises not found", content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public List<ExerciseDTO> getExercises() {
        log.debug("REST request to get exercises");
        return exerciseService.findAll();
    }


    @GetMapping("/slug/{slug}")
    @ApiResponse(responseCode = "200", description = "Return a exercise by its slug")
    @Operation(summary = "Find a exercise by its slug", description = "This endpoint allows to find a exercise by its slug")
    public ResponseEntity<ExerciseDTO> findExerciseBySlug(
            @Parameter(required = true, description = "Slug of the exercise to be retrieved")
            @PathVariable String slug
    ) {
        log.debug("REST request to get Exercise by slug : {}", slug);
        Optional<ExerciseDTO> exercise = exerciseService.findBySlug(slug);
        if (exercise.isPresent()) {
            return new ResponseEntity<>(exercise.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
