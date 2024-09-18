package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "training")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingProgram extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "Total_duration", nullable = false)
    private String totalDuration;

    @Column(name = "level-required", nullable = false)
    private String levelRequired;

    @Column(name = "program_objective", nullable = false)
    private String programObjective;

    @OneToMany
    private List<Routine> routines;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
