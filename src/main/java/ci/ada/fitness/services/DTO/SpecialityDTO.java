package ci.ada.fitness.services.DTO;

import ci.ada.fitness.models.Coach;
import ci.ada.fitness.models.User;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SpecialityDTO{

    private Long id;

    private String name;

    private String description;

    private String slug;

    private Set<CoachDTO> coaches;

    private UserDTO user;
}
