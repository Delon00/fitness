package ci.ada.fitness.web.resources;

import ci.ada.fitness.services.SpecialityService;
import ci.ada.fitness.services.DTO.SpecialityDTO;
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
@RequestMapping("api/specialities")
public class SpecialityRessource {

    private final SpecialityService specialityService;


    @PostMapping
    @ApiResponse(responseCode = "200", description = "Request to save Speciality")
    @Operation(summary = "save new speciality", description = "this endpoint allow to save speciality")
    public ResponseEntity<SpecialityDTO> saveSpeciality(@RequestBody SpecialityDTO speciality) {
        log.debug("REST request to save speciality {}", speciality);
        return new ResponseEntity<>(specialityService.save(speciality), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "201", description = "Request to update Speciality")
    public SpecialityDTO updateSpeciality(@RequestBody SpecialityDTO speciality, @PathVariable Long id) {
        log.debug("REST request to update speciality {}", speciality);
        return specialityService.update(speciality, id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to delete Speciality")
    public void deleteSpeciality(@PathVariable Long id) {
        log.debug("REST request to delete speciality {}", id);
        specialityService.delete(id);
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to get Speciality")
    public ResponseEntity<?> getSpeciality(
            @Parameter(required = true, description = "ID of speciality to be retrieved")
            @PathVariable Long id
    ) {
        log.debug("REST request to get speciality {}", id);

        Optional<SpecialityDTO> speciality = specialityService.findById(id);

        if (speciality.isPresent()) {
            return new ResponseEntity<>(speciality.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Speciality not found", HttpStatus.NOT_FOUND);
    }


    @GetMapping
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "Request to get Specialitys"),
                    @ApiResponse(responseCode = "404", description = "Specialitys not found", content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public List<SpecialityDTO> getSpecialitys() {
        log.debug("REST request to get specialitys");
        return specialityService.findAll();
    }


    @GetMapping("/slug/{slug}")
    @ApiResponse(responseCode = "200", description = "Return a speciality by its slug")
    @Operation(summary = "Find a speciality by its slug", description = "This endpoint allows to find a speciality by its slug")
    public ResponseEntity<SpecialityDTO> findSpecialityBySlug(
            @Parameter(required = true, description = "Slug of the speciality to be retrieved")
            @PathVariable String slug
    ) {
        log.debug("REST request to get Speciality by slug : {}", slug);
        Optional<SpecialityDTO> speciality = specialityService.findBySlug(slug);
        if (speciality.isPresent()) {
            return new ResponseEntity<>(speciality.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}