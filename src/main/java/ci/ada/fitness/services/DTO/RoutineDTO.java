package ci.ada.fitness.services.DTO;

import ci.ada.fitness.models.Exercise;
import ci.ada.fitness.models.Performance;
import ci.ada.fitness.models.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RoutineDTO {

    private Long id;

    private Date date;

    private List<ExerciseDTO> exercices;

    private UserDTO user;

    private List<PerformanceDTO> performances;
}

