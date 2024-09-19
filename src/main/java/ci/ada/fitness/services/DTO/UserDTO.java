package ci.ada.fitness.services.DTO;

import ci.ada.fitness.models.Routine;
import ci.ada.fitness.models.Speciality;
import ci.ada.fitness.models.TrainingProgram;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Integer birthday;

    private Integer weight;

    private Integer size;

    private String objective;

    private String slug;

    private Speciality speciality;

}
