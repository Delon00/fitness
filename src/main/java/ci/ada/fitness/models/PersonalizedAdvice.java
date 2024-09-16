package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "conseil_personnalise")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalizedAdvice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private User utilisateur;

    private String date;

    private String conseil;

    private String categorie;
}
