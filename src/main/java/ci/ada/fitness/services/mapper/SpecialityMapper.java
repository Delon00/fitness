package ci.ada.fitness.services.mapper;

import ci.ada.fitness.models.Speciality;
import ci.ada.fitness.services.DTO.SpecialityDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpecialityMapper extends EntityMapper<SpecialityDTO, Speciality>  {
}
