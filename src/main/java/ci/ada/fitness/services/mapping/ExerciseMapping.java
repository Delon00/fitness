package ci.ada.fitness.services.mapping;

public final  class ExerciseMapping {
    private ExerciseMapping(){

    }
    public static void partialUpdate(Exercise exercise, ExerciseDTO exerciseDTO){
        if (exerciseDTO.getNumber()!=null){
          exercise.setNumber(exerciseDTO.getNumber());
        }
        if(exerciseDTO.getType_Exercise()!=null){
           exercise.setType_Exercise(exerciseDTO.getType_Exercise());
        }
    }
}
