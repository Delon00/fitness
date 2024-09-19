package ci.ada.fitness.services.DTO;

import ci.ada.fitness.models.Routine;
import ci.ada.fitness.models.TrainingProgram;
import lombok.Data;

import java.util.List;
import java.util.Set;
@Data
public class ClientDTO extends UserDTO{

    private String level;

    private String objective;

    private List<Routine> routines;

    private Set<TrainingProgram> trainingPrograms;
}
