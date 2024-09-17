package ci.ada.fitness.services.DTO;

import lombok.Data;
import java.util.List;

@Data
public class TrainingProgramDTO {

    private Long id;

    private String name;

    private String description;

    private Integer TotalDuration;

    private String levelRequired;

    private String ProgramObjective;

    private List<RoutineDTO> routines;

    private UserDTO user;
}
