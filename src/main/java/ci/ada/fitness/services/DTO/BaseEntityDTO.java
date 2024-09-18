package ci.ada.fitness.services.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntityDTO {

    private Long id;

    private String slug;
}
