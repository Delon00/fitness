package ci.ada.fitness.services.DTO;

import lombok.Data;
import java.io.Serializable;

@Data
public class BaseEntityDTO implements Serializable {

    private Long id;
    private String slug;
}
