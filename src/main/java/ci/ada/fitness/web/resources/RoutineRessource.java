package ci.ada.fitness.web.resources;

import ci.ada.fitness.services.DTO.RoutineDTO;
import ci.ada.fitness.services.RoutineService;
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
@RequestMapping("api/routines")
public class RoutineRessource {

    private final RoutineService routineService;


    @PostMapping
    @ApiResponse(responseCode = "200", description = "Request to save Routine")
    @Operation(summary = "save new routine", description = "this endpoint allow to save routine")
    public ResponseEntity<RoutineDTO> saveRoutine(@RequestBody RoutineDTO routine) {
        log.debug("REST request to save routine {}", routine);
        return new ResponseEntity<>(routineService.save(routine), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "201", description = "Request to update Routine")
    public RoutineDTO updateRoutine(@RequestBody RoutineDTO routine, @PathVariable Long id) {
        log.debug("REST request to update routine {}", routine);
        return routineService.update(routine, id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to delete Routine")
    public void deleteRoutine(@PathVariable Long id) {
        log.debug("REST request to delete routine {}", id);
        routineService.delete(id);
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to get Routine")
    public ResponseEntity<?> getRoutine(
            @Parameter(required = true, description = "ID of routine to be retrieved")
            @PathVariable Long id
    ) {
        log.debug("REST request to get routine {}", id);

        Optional<RoutineDTO> routine = routineService.findById(id);

        if (routine.isPresent()) {
            return new ResponseEntity<>(routine.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Routine not found", HttpStatus.NOT_FOUND);
    }


    @GetMapping
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "Request to get Routines"),
                    @ApiResponse(responseCode = "404", description = "Routines not found", content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public List<RoutineDTO> getRoutines() {
        log.debug("REST request to get routines");
        return routineService.findAll();
    }


//    @GetMapping("/slug/{slug}")
//    @ApiResponse(responseCode = "200", description = "Return a routine by its slug")
//    @Operation(summary = "Find a routine by its slug", description = "This endpoint allows to find a routine by its slug")
//    public ResponseEntity<RoutineDTO> findRoutineBySlug(
//            @Parameter(required = true, description = "Slug of the routine to be retrieved")
//            @PathVariable String slug
//    ) {
//        log.debug("REST request to get Routine by slug : {}", slug);
//        Optional<RoutineDTO> routine = routineService.findBySlug(slug);
//        if (routine.isPresent()) {
//            return new ResponseEntity<>(routine.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}
