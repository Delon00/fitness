package ci.ada.fitness.services.DTO;

import lombok.Data;

@Data
public class PerformanceDTO {

    private Long id;

    private String date;

    private Integer repetition;

    private Float weightUsed;

    private Integer timeExercise;

    private String slug;

    private Float caloriesBurned;

    private UserDTO user;

    private RoutineDTO routine;

    private ExerciseDTO exercise;
}

