package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "performance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private User utilisateur;

    @ManyToOne
    @JoinColumn(name = "routine_id")
    private Routine routine;

    @ManyToOne
    @JoinColumn(name = "exercice_id")
    private Exercise exercice;

    private String date;

    private Integer repetitions;

    private Float poidsUtilise;

    private Integer tempsExercice;

    private Float caloriesBrulees;
}

