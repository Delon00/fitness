package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "programme_entraînement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingProgram implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "name", nullable = false)
    private String description;

    @Column(name = "Total_duration", nullable = false)
    private Integer TotalDuration;

    @Column(name = "level-required", nullable = false)
    private String levelRequired;

    @Column(name = "Program_objective", nullable = false)
    private String ProgramObjective;

    @OneToMany(mappedBy = "trainingProgram")
    private List<Routine> routines;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
