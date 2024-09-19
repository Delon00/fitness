package ci.ada.fitness.services.mapping;

import ci.ada.fitness.models.User;
import ci.ada.fitness.services.DTO.UserDTO;

public class UserMapping {

    private UserMapping(){

    }

    public static void partialUpdate(User user, UserDTO userDTO) {
        if(userDTO.getLevel() != null) {
            user.setLevel(userDTO.getLevel());
        }
        if(userDTO.getObjective() != null) {
            user.setObjective(userDTO.getObjective());
        }
    }
}
