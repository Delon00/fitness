package ci.ada.fitness.services.mapping;

import ci.ada.fitness.models.Performance;
import ci.ada.fitness.services.DTO.PerformanceDTO;

public class PerformanceMapping {

    private PerformanceMapping(){

    }

    public static void partialUpdate(Performance performance, PerformanceDTO performanceDTO){
        if(performanceDTO.getDate() != null) {
            performance.setDate(performanceDTO.getDate());
        }
        if(performanceDTO.getRepetition() != null) {
            performance.setRepetition(performanceDTO.getRepetition());
        }
        if(performanceDTO.getWeightUsed() != null) {
            performance.setWeightUsed(performanceDTO.getWeightUsed());
        }
    }
}
