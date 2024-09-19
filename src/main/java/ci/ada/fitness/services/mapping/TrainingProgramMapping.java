package ci.ada.fitness.services.mapping;

import ci.ada.fitness.models.TrainingProgram;
import ci.ada.fitness.services.DTO.TrainingProgramDTO;

public class TrainingProgramMapping {

    private TrainingProgramMapping(){

    }
    public static void partialUpdate(TrainingProgram trainingProgram, TrainingProgramDTO trainingProgramDTO){

        if(trainingProgramDTO.getName() != null) {
            trainingProgram.setName(trainingProgramDTO.getName());
        }
        if(trainingProgramDTO.getDescription() != null) {
            trainingProgram.setDescription(trainingProgramDTO.getDescription());
        }
        if(trainingProgramDTO.getLevelRequired() != null) {
            trainingProgram.setLevelRequired(trainingProgramDTO.getLevelRequired());
        }
    }

}

