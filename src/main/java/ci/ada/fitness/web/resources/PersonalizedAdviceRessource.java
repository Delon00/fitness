package ci.ada.fitness.web.resources;

import ci.ada.fitness.services.DTO.PersonalizedAdviceDTO;
import ci.ada.fitness.services.PersonalizedAdviceService;
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
@RequestMapping("api/personalized-advices")
public class PersonalizedAdviceRessource {

    private final PersonalizedAdviceService personalizedAdviceService;

    @PostMapping
    @ApiResponse(responseCode = "200", description = "Request to save PersonalizedAdvice")
    @Operation(summary = "save new personalizedAdvice", description = "this endpoint allow to save personalizedAdvice")
    public ResponseEntity<PersonalizedAdviceDTO> savePersonalizedAdvice(@RequestBody PersonalizedAdviceDTO personalizedAdvice) {
        log.debug("REST request to save personalizedAdvice {}", personalizedAdvice);
        return new ResponseEntity<>(personalizedAdviceService.save(personalizedAdvice), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "201", description = "Request to update PersonalizedAdvice")
    public PersonalizedAdviceDTO updatePersonalizedAdvice(@RequestBody PersonalizedAdviceDTO personalizedAdvice, @PathVariable Long id) {
        log.debug("REST request to update personalizedAdvice {}", personalizedAdvice);
        return personalizedAdviceService.update(personalizedAdvice, id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to delete PersonalizedAdvice")
    public void deletePersonalizedAdvice(@PathVariable Long id) {
        log.debug("REST request to delete personalizedAdvice {}", id);
        personalizedAdviceService.delete(id);
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to get PersonalizedAdvice")
    public ResponseEntity<?> getPersonalizedAdvice(
            @Parameter(required = true, description = "ID of personalizedAdvice to be retrieved")
            @PathVariable Long id
    ) {
        log.debug("REST request to get personalizedAdvice {}", id);

        Optional<PersonalizedAdviceDTO> personalizedAdvice = personalizedAdviceService.findById(id);

        if (personalizedAdvice.isPresent()) {
            return new ResponseEntity<>(personalizedAdvice.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("PersonalizedAdvice not found", HttpStatus.NOT_FOUND);
    }


    @GetMapping
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "Request to get PersonalizedAdvices"),
                    @ApiResponse(responseCode = "404", description = "PersonalizedAdvices not found", content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public List<PersonalizedAdviceDTO> getPersonalizedAdvices() {
        log.debug("REST request to get personalizedAdvices");
        return personalizedAdviceService.findAll();
    }


    @GetMapping("/slug/{slug}")
    @ApiResponse(responseCode = "200", description = "Return a personalizedAdvice by its slug")
    @Operation(summary = "Find a personalizedAdvice by its slug", description = "This endpoint allows to find a personalizedAdvice by its slug")
    public ResponseEntity<PersonalizedAdviceDTO> findPersonalizedAdviceBySlug(
            @Parameter(required = true, description = "Slug of the personalizedAdvice to be retrieved")
            @PathVariable String slug
    ) {
        log.debug("REST request to get PersonalizedAdvice by slug : {}", slug);
        Optional<PersonalizedAdviceDTO> personalizedAdvice = personalizedAdviceService.findBySlug(slug);
        if (personalizedAdvice.isPresent()) {
            return new ResponseEntity<>(personalizedAdvice.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}