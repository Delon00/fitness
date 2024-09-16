package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "exercice")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;

    private String musclesTravailles;

    private Integer duree;

    private String difficulte;

    private String typeExercice;

    @OneToMany(mappedBy = "exercice", cascade = CascadeType.ALL)
    private List<Performance> performances;

    @ManyToMany(mappedBy = "exercices")
    private List<Routine> routines;
}
