package ci.ada.fitness.web.resources;

import ci.ada.fitness.services.DTO.TrainingProgramDTO;
import ci.ada.fitness.services.TrainingProgramService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping("api/trainings")
public class TrainingProgramRessource {

    private final TrainingProgramService trainingProgramService;

    @PostMapping
    @ApiResponse(responseCode = "200", description = "Request to save TrainingProgram")
    @Operation(summary = "save new trainingProgram", description = "this endpoint allow to save trainingProgram")
    public ResponseEntity<TrainingProgramDTO> saveTraining(@RequestBody TrainingProgramDTO trainingProgram) {
        log.debug("REST request to save trainingProgram {}", trainingProgram);
        return new ResponseEntity<>(trainingProgramService.save(trainingProgram), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "201", description = "Request to update TrainingProgram")
    public TrainingProgramDTO updateTrainingProgram(@RequestBody TrainingProgramDTO trainingProgram, @PathVariable Long id) {
        log.debug("REST request to update trainingProgram {}", trainingProgram);
        return trainingProgramService.update(trainingProgram, id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to delete TrainingProgram")
    public void deleteTrainingProgram(@PathVariable Long id) {
        log.debug("REST request to delete trainingProgram {}", id);
        trainingProgramService.delete(id);
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to get TrainingProgram")
    public ResponseEntity<?> getTrainingProgram(
            @Parameter(required = true, description = "ID of trainingProgram to be retrieved")
            @PathVariable Long id
    ) {
        log.debug("REST request to get trainingProgram {}", id);

        Optional<TrainingProgramDTO> trainingProgram = trainingProgramService.findById(id);

        if (trainingProgram.isPresent()) {
            return new ResponseEntity<>(trainingProgram.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("TrainingProgram not found", HttpStatus.NOT_FOUND);
    }


    @GetMapping
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "Request to get TrainingPrograms"),
            }
    )
    public List<TrainingProgramDTO> getTrainingPrograms() {
        log.debug("REST request to get trainingPrograms");
        return trainingProgramService.findAll();
    }


    @GetMapping("/slug/{slug}")
    @ApiResponse(responseCode = "200", description = "Return a trainingProgram by its slug")
    @Operation(summary = "Find a trainingProgram by its slug", description = "This endpoint allows to find a trainingProgram by its slug")
    public ResponseEntity<TrainingProgramDTO> findTrainingProgramBySlug(
            @Parameter(required = true, description = "Slug of the trainingProgram to be retrieved")
            @PathVariable String slug
    ) {
        log.debug("REST request to get TrainingProgram by slug : {}", slug);
        Optional<TrainingProgramDTO> trainingProgram = trainingProgramService.findBySlug(slug);
        if (trainingProgram.isPresent()) {
            return new ResponseEntity<>(trainingProgram.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
