package ci.ada.fitness.services.DTO;

import ci.ada.fitness.models.Routine;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseDTO {

    private Long id;

    private String name;

    private String description;

    private String difficulty;

    private String duration;

    private String slug;

    private RoutineDTO routine;

}
