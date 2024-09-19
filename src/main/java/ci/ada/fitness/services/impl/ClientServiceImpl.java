package ci.ada.fitness.services.impl;

import ci.ada.fitness.models.Client;
import ci.ada.fitness.repositories.ClientRepository;
import ci.ada.fitness.services.ClientService;
import ci.ada.fitness.services.DTO.ClientDTO;
import ci.ada.fitness.services.ClientService;
import ci.ada.fitness.services.mapper.ClientMapper;
import ci.ada.fitness.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        log.debug("Request to save client: {}", clientDTO);
        final String slug = SlugifyUtils.generate(String.valueOf(clientDTO.getEmail()));
        clientDTO.setSlug(slug);
        Client client = clientMapper.toEntity(clientDTO);
        log.debug("Client after mapping{}", client);
        client = clientRepository.save(client);
        return clientMapper.toDto(client);
    }

    @Override
    public ClientDTO update(ClientDTO clientDTO) {
        return findOne(clientDTO.getId()).map(existingClient -> {
            existingClient.setBirthday(clientDTO.getBirthday());
            existingClient.setEmail(clientDTO.getEmail());
            return save(existingClient);
        }).orElseThrow(()-> new RuntimeException("Client not found"));
    }

    @Override
    public ClientDTO update(ClientDTO clientDTO, Long id) {
        clientDTO.setId(id);
        return update(clientDTO);
    }

    @Override
    public Optional<ClientDTO> findOne(Long id) {
        return clientRepository.findById(id).map(clientMapper::toDto);
    }

    @Override
    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream().map(clientMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete client: {}", id);
        clientRepository.deleteById(id);
    }

    @Override
    public Optional<ClientDTO> findById(Long id) {
        return clientRepository.findById(id).map(clientMapper::toDto);
    }

    @Override
    public Optional<ClientDTO> findBySlug(String slug) {
        log.debug("Request to get client by slug:{}", slug);
        return clientRepository.findBySlug(slug).map(clientMapper::toDto);
    }

    @Override
    public ClientDTO partialUpdate(ClientDTO clientDTO, Long id) {
        log.debug("Request to partial update client with id : {} ", id);
        return clientRepository.findById(id).map(client -> {
            //ClientMapping.partialUpdate(client, clientDTO);
            return client;
        }).map(clientRepository::save).map(clientMapper::toDto).orElse(null);
    }
}
