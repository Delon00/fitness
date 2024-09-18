package ci.ada.fitness.services.mapping;

import ci.ada.fitness.models.PersonalizedAdvice;
import ci.ada.fitness.services.DTO.PersonalizedAdviceDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonalizedAdviceMapping {
    private PersonalizedAdviceMapping(){

    }
    public static void partialUpdate(PersonalizedAdvice personalizedAdvice, PersonalizedAdviceDTO personalizedAdviceDTO) {
        if(personalizedAdviceDTO.getAdvice() != null) {
            personalizedAdvice.setAdvice(personalizedAdviceDTO.getAdvice());
        }
        if(personalizedAdviceDTO.getCategory() != null) {
            personalizedAdvice.setCategory(personalizedAdviceDTO.getCategory());
        }
    }
}
