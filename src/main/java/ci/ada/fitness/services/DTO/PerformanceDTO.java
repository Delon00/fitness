package ci.ada.fitness.services.DTO;

import lombok.Data;

@Data
public class PerformanceDTO {

    private Long id;

    private String slug;

    private RoutineDTO routine;

    private ExerciseDTO exercise;
}

