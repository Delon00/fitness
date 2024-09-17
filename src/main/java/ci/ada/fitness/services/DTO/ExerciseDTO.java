package ci.ada.fitness.services.DTO;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ExerciseDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String number;

    private String description;

    private String musclesWork;

    private Integer date;

    private String difficulty;

    private String type_Exercise;

    private Set<RoutineDTO> routines;

    private List<PerformanceDTO> performances;
}
