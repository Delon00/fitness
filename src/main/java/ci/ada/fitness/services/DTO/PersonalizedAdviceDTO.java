package ci.ada.fitness.services.DTO;

import lombok.Data;

@Data
public class PersonalizedAdviceDTO {
    private Long id;
    private Long utilisateurId;
    private String date;
    private String conseil;
    private String categorie;
}

