package ci.ada.fitness.services.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class RoutineDTO extends BaseEntityDTO  {

    private Long id;

    private Date date;


//    private List<ExerciseDTO> exercises;
//
    private List<PerformanceDTO> performances;

    private TrainingProgramDTO trainingProgram;

}

