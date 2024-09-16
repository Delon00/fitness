package ci.ada.fitness.services.DTO;

import lombok.Data;
import java.util.List;

@Data
public class RoutineDTO {
    private Long id;
    private String date;
    private Long programmeId;
    private Long utilisateurId;
    private List<ExerciseDTO> exercices;
}

