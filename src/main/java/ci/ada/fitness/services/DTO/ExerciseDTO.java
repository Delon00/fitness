package ci.ada.fitness.services.DTO;

import lombok.Data;

@Data
public class ExerciseDTO {
    private Long id;
    private String nom;
    private String description;
    private String musclesTravailles;
    private Integer duree;
    private String difficulte;
    private String typeExercice;
}
