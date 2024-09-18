package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "exercise")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "difficulty", nullable = false)
    private String difficulty;

    @Column(name = "type_exercise", nullable = false)
    private String type_Exercise;

    @Column(name = "slug", unique = true, nullable = false)
    private String slug;

    @ManyToMany
    private Set<Routine> routines;

    @OneToMany(mappedBy = "exercise")
    private List<Performance> performances;

}
