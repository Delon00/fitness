package ci.ada.fitness.services.DTO;

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

    private Float weight;

    private Float size;

    private String objective;

    private String slug;

    private List<RoutineDTO> routines;

    private Set<TrainingProgramDTO> trainingPrograms;

}
