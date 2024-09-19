package ci.ada.fitness.web.resources;

import ci.ada.fitness.services.CoachService;
import ci.ada.fitness.services.DTO.CoachDTO;
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
@RequestMapping("api/coaches")
public class CoachRessource {

    private final CoachService coachService;


    @PostMapping
    @ApiResponse(responseCode = "200", description = "Request to save Coach")
    @Operation(summary = "save new coach", description = "this endpoint allow to save coach")
    public ResponseEntity<CoachDTO> saveCoach(@RequestBody CoachDTO coach) {
        log.debug("REST request to save coach {}", coach);
        return new ResponseEntity<>(coachService.save(coach), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "201", description = "Request to update Coach")
    public CoachDTO updateCoach(@RequestBody CoachDTO coach, @PathVariable Long id) {
        log.debug("REST request to update coach {}", coach);
        return coachService.update(coach, id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to delete Coach")
    public void deleteCoach(@PathVariable Long id) {
        log.debug("REST request to delete coach {}", id);
        coachService.delete(id);
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to get Coach")
    public ResponseEntity<?> getCoach(
            @Parameter(required = true, description = "ID of coach to be retrieved")
            @PathVariable Long id
    ) {
        log.debug("REST request to get coach {}", id);

        Optional<CoachDTO> coach = coachService.findById(id);

        if (coach.isPresent()) {
            return new ResponseEntity<>(coach.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Coach not found", HttpStatus.NOT_FOUND);
    }


    @GetMapping
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "Request to get Coachs"),
                    @ApiResponse(responseCode = "404", description = "Coachs not found", content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public List<CoachDTO> getCoachs() {
        log.debug("REST request to get coachs");
        return coachService.findAll();
    }


//    @GetMapping("/slug/{slug}")
//    @ApiResponse(responseCode = "200", description = "Return a coach by its slug")
//    @Operation(summary = "Find a coach by its slug", description = "This endpoint allows to find a coach by its slug")
//    public ResponseEntity<CoachDTO> findCoachBySlug(
//            @Parameter(required = true, description = "Slug of the coach to be retrieved")
//            @PathVariable String slug
//    ) {
//        log.debug("REST request to get Coach by slug : {}", slug);
//        Optional<CoachDTO> coach = coachService.findBySlug(slug);
//        if (coach.isPresent()) {
//            return new ResponseEntity<>(coach.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}
