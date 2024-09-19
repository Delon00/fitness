package ci.ada.fitness.services.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CoachDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String slug;

    private Set<SpecialityDTO> specialities;
}
