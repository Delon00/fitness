package ci.ada.fitness.services.DTO;

import ci.ada.fitness.models.Exercise;
import ci.ada.fitness.models.PersonalizedAdvice;
import ci.ada.fitness.models.TrainingProgram;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class RoutineDTO {

    private Long id;

    private String name;

    private Date date;

    private String slug;

    private TrainingProgramDTO trainingProgram;

    private PersonalizedAdviceDTO personalizedAdvice;

    private List<ExerciseDTO> exercises;

}

