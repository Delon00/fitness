package ci.ada.fitness.services.mapping;

import ci.ada.fitness.models.Performance;
import ci.ada.fitness.services.DTO.PerformanceDTO;

public class PerformanceMapping {

    private PerformanceMapping(){

    }

    public static void partialUpdate(Performance performance, PerformanceDTO performanceDTO){
        if(performanceDTO.getSlug() != null) {
            performance.setSlug(performanceDTO.getSlug());
        }
    }
}
