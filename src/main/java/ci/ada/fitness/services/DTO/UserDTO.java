package ci.ada.fitness.services.DTO;

import ci.ada.fitness.models.Performance;
import ci.ada.fitness.models.PersonalizedAdvice;
import ci.ada.fitness.models.Routine;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private Long id;
    private String nom;
    private String email;
    private String motDePasse;
    private Integer age;
    private Float poids;
    private Float taille;
    private String niveau;
    private String objectif;
    private List<Performance> performances;

    private List<PersonalizedAdvice> conseilsPersonnalises;

    private List<Routine> routines;
}
