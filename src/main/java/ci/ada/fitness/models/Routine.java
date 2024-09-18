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
@AllArgsConstructor
public class Routine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "slug", unique = true, nullable = false)
    private String slug;

    @Column(name = "exercise", nullable = false)
    private String exercise;

    @ManyToOne
    @JoinColumn(name = "training_program_id")
    private TrainingProgram trainingProgram;

}
