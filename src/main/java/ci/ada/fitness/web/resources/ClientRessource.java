package ci.ada.fitness.web.resources;

import ci.ada.fitness.services.ClientService;
import ci.ada.fitness.services.DTO.ClientDTO;
import ci.ada.fitness.services.ClientService;
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
@RequestMapping("api/clients")
public class ClientRessource {

    private final ClientService clientService;


    @PostMapping
    @ApiResponse(responseCode = "200", description = "Request to save Client")
    @Operation(summary = "save new client", description = "this endpoint allow to save client")
    public ResponseEntity<ClientDTO> saveClient(@RequestBody ClientDTO client) {
        log.debug("REST request to save client {}", client);
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "201", description = "Request to update Client")
    public ClientDTO updateClient(@RequestBody ClientDTO client, @PathVariable Long id) {
        log.debug("REST request to update client {}", client);
        return clientService.update(client, id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to delete Client")
    public void deleteClient(@PathVariable Long id) {
        log.debug("REST request to delete client {}", id);
        clientService.delete(id);
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to get Client")
    public ResponseEntity<?> getClient(
            @Parameter(required = true, description = "ID of client to be retrieved")
            @PathVariable Long id
    ) {
        log.debug("REST request to get client {}", id);

        Optional<ClientDTO> client = clientService.findById(id);

        if (client.isPresent()) {
            return new ResponseEntity<>(client.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
    }


    @GetMapping
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "Request to get Clients"),
                    @ApiResponse(responseCode = "404", description = "Clients not found", content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public List<ClientDTO> getClients() {
        log.debug("REST request to get clients");
        return clientService.findAll();
    }


    @GetMapping("/slug/{slug}")
    @ApiResponse(responseCode = "200", description = "Return a client by its slug")
    @Operation(summary = "Find a client by its slug", description = "This endpoint allows to find a client by its slug")
    public ResponseEntity<ClientDTO> findClientBySlug(
            @Parameter(required = true, description = "Slug of the client to be retrieved")
            @PathVariable String slug
    ) {
        log.debug("REST request to get Client by slug : {}", slug);
        Optional<ClientDTO> client = clientService.findBySlug(slug);
        if (client.isPresent()) {
            return new ResponseEntity<>(client.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}