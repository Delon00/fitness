package ci.ada.fitness.services.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecialityDTO extends BaseEntityDTO{

    private Long id;

    private String name;

    private String description;

    private String slug;

    private set<CoachDTO> coaches;
}
