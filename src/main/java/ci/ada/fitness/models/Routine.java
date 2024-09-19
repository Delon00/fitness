package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "routine")
@Data
@NoArgsConstructor
public class Routine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "slug", unique = true, nullable = false)
    private String slug;

    @ManyToOne
    @JoinColumn(name = "personalized_advice_id")
    private PersonalizedAdvice personalizedAdvice;

    @OneToOne
    private TrainingProgram trainingProgram;

    @OneToMany(mappedBy = "routine", cascade = CascadeType.ALL)
    private List<Exercise> exercises;

}
