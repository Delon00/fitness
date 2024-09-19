package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "training_program")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingProgram implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "Total_duration", nullable = false)
    private String totalDuration;

    @Column(name = "slug", unique = true, nullable = false)
    private String slug;

    @OneToMany
    private List<Routine> routines;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
