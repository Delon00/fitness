package ci.ada.fitness.services.mapping;

import ci.ada.fitness.models.Routine;
import ci.ada.fitness.services.DTO.RoutineDTO;

public class RoutineMapping {

    private RoutineMapping(){

    }

    public static void partialUpdate(Routine routine, RoutineDTO routineDTO) {

        if(routineDTO.getDate() != null) {
            routine.setDate(routineDTO.getDate());
        }
        if(routineDTO.getSlug() != null) {
            routine.setSlug(routineDTO.getSlug());
        }
    }
}
