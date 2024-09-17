package ci.ada.fitness.services.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class PersonalizedAdviceDTO {

    private Long id;

    private Date date;

    private String advice;

    private String category;

    private String slug;

    private UserDTO user;

    private RoutineDTO routine;
}

