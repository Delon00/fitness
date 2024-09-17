package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "exercice")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "muscles_work", nullable = false)
    private String musclesWork;

    @Column(name = "date", nullable = false)
    private Integer date;

    @Column(name = "difficulty", nullable = false)
    private String difficulty;

    @Column(name = "type_exercise", nullable = false)
    private String type_Exercise;

    @ManyToMany(mappedBy = "exercises")
    private Set<Routine> routines;

    @OneToMany(mappedBy = "exercise")
    private List<Performance> performances;

}
