package ci.ada.fitness.services.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class RoutineDTO {

    private Long id;

    private Date date;

    private String slug;

//    private List<ExerciseDTO> exercises;
//
//    private List<PerformanceDTO> performances;

    private TrainingProgramDTO trainingProgram;

}

