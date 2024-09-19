package ci.ada.fitness.services.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
public class PersonalizedAdviceDTO {

    private Long id;

    private String content;

    private Instant dateAdvice;

    private String slug;

    private RoutineDTO routine;
}

