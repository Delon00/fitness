package ci.ada.fitness.services.DTO;

import lombok.Data;
import java.util.List;

@Data
public class TrainingProgramDTO {
    private Long id;
    private String nom;
    private String description;
    private Integer dureeTotale;
    private String niveauRequis;
    private String objectifProgramme;
    private List<RoutineDTO> routines;
}
