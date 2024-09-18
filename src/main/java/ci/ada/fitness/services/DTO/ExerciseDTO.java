package ci.ada.fitness.services.DTO;

import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Data
public class ExerciseDTO {

    private Long id;

    private String name;

    private String number;

    private String description;

    private Date date;

    private String slug;

    private String difficulty;

    private String type_Exercise;

    private Set<RoutineDTO> routines;

    private List<PerformanceDTO> performances;
}
