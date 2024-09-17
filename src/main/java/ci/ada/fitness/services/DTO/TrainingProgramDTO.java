package ci.ada.fitness.services.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TrainingProgramDTO {

    private Long id;

    private String name;

    private String description;

    private String totalDuration;

    private String levelRequired;

    private String slug;

    private String programObjective;

    private List<RoutineDTO> routines;

    private UserDTO user;
}
