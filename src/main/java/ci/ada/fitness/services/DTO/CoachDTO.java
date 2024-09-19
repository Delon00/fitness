package ci.ada.fitness.services.DTO;

import ci.ada.fitness.models.Speciality;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CoachDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String slug;

    private Speciality speciality;

}
