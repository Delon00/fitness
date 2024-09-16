package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "utilisateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String motDePasse;

    private Integer age;

    private Float poids;

    private Float taille;

    private String niveau;

    private String objectif;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Performance> performances;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<PersonalizedAdvice> conseilsPersonnalises;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Routine> routines;
}
