package ci.ada.fitness.web.resources;

import ci.ada.fitness.services.DTO.PerformanceDTO;
import ci.ada.fitness.services.PerformanceService;
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
@RequestMapping("api/performances")
public class PerformanceRessource {

    private final PerformanceService performanceService;


    @PostMapping
    @ApiResponse(responseCode = "200", description = "Request to save Performance")
    @Operation(summary = "save new performance", description = "this endpoint allow to save performance")
    public ResponseEntity<PerformanceDTO> savePerformance(@RequestBody PerformanceDTO performance) {
        log.debug("REST request to save performance {}", performance);
        return new ResponseEntity<>(performanceService.save(performance), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "201", description = "Request to update Performance")
    public PerformanceDTO updatePerformance(@RequestBody PerformanceDTO performance, @PathVariable Long id) {
        log.debug("REST request to update performance {}", performance);
        return performanceService.update(performance, id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to delete Performance")
    public void deletePerformance(@PathVariable Long id) {
        log.debug("REST request to delete performance {}", id);
        performanceService.delete(id);
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to get Performance")
    public ResponseEntity<?> getPerformance(
            @Parameter(required = true, description = "ID of performance to be retrieved")
            @PathVariable Long id
    ) {
        log.debug("REST request to get performance {}", id);

        Optional<PerformanceDTO> performance = performanceService.findById(id);

        if (performance.isPresent()) {
            return new ResponseEntity<>(performance.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Performance not found", HttpStatus.NOT_FOUND);
    }


    @GetMapping
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "Request to get Performances"),
                    @ApiResponse(responseCode = "404", description = "Performances not found", content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public List<PerformanceDTO> getPerformances() {
        log.debug("REST request to get performances");
        return performanceService.findAll();
    }


    @GetMapping("/slug/{slug}")
    @ApiResponse(responseCode = "200", description = "Return a performance by its slug")
    @Operation(summary = "Find a performance by its slug", description = "This endpoint allows to find a performance by its slug")
    public ResponseEntity<PerformanceDTO> findPerformanceBySlug(
            @Parameter(required = true, description = "Slug of the performance to be retrieved")
            @PathVariable String slug
    ) {
        log.debug("REST request to get Performance by slug : {}", slug);
        Optional<PerformanceDTO> performance = performanceService.findBySlug(slug);
        if (performance.isPresent()) {
            return new ResponseEntity<>(performance.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
