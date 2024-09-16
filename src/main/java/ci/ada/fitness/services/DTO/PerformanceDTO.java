package ci.ada.fitness.services.DTO;

import lombok.Data;

@Data
public class PerformanceDTO {
    private Long id;
    private Long utilisateurId;
    private Long routineId;
    private Long exerciceId;
    private String date;
    private Integer repetitions;
    private Float poidsUtilise;
    private Integer tempsExercice;
    private Float caloriesBrulees;
}

