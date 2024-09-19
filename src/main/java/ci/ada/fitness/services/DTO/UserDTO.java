package ci.ada.fitness.services.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO extends BaseEntityDTO implements Serializable {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;

    private Integer birthday;
}
