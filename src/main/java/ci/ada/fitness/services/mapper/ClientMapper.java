package ci.ada.fitness.services.mapper;

import ci.ada.fitness.models.Client;

import ci.ada.fitness.services.DTO.ClientDTO;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClientMapper extends EntityMapper<ClientDTO, Client>{
}
