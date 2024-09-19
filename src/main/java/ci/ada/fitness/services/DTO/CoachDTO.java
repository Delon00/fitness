package ci.ada.fitness.services.DTO;

import ci.ada.fitness.models.User;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class CoachDTO extends BaseEntityDTO{

    private String specialty;

    private List<User> users;
}
