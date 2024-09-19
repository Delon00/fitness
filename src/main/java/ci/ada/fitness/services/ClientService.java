package ci.ada.fitness.services;


import ci.ada.fitness.services.DTO.ClientDTO;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    ClientDTO save(ClientDTO clientDTO);

    ClientDTO update(ClientDTO clientDTO);

    ClientDTO update(ClientDTO clientDTO, Long id);

    Optional<ClientDTO> findOne(Long id);

    List<ClientDTO> findAll();

    void delete(Long id);

    Optional<ClientDTO>findById(Long id);

    Optional<ClientDTO> findBySlug(String slug);

    ClientDTO partialUpdate(ClientDTO clientDTO, Long id);
}
