package ci.ada.fitness.services.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SpecialityDTO extends BaseEntityDTO{

    private Long id;

    private String name;

    private String description;

    private String slug;

    private Set<CoachDTO> coaches;
}
