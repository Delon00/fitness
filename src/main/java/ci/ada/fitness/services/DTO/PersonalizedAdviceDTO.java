package ci.ada.fitness.services.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class PersonalizedAdviceDTO extends BaseEntityDTO {


    private Date date;

    private String advice;

    private String category;
    private RoutineDTO routine;
}

