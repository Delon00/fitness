package ci.ada.fitness.services.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseDTO  {

    private Long id;

    private String name;

    private String description;

    private String difficulty;

    private String duration;

    private String slug;

}
