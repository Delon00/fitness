package ci.ada.fitness.services.DTO;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Integer birthday;

    private Float weight;

    private Float size;

    private String level;

    private String objective;

    private String slug;

    private List<PerformanceDTO> performances;

    private List<RoutineDTO> routines;

    private Set<TrainingProgramDTO> trainingPrograms;

    private List<PersonalizedAdviceDTO> advices;
}
