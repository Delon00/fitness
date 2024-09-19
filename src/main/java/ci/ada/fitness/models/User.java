package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "birthday", nullable = false)
    private Integer birthday;

    @Column(name = "weight", nullable = false)
    private Float weight;

    @Column(name = "size", nullable = false)
    private Float size;

    @Column(name = "level", nullable = false)
    private String level;

    @Column(name = "objective", nullable = false)
    private String objective;

    @Column(name = "slug", unique = true, nullable = false)
    private String slug;

    @OneToMany
    private List<Routine> routines;

    @OneToMany
    private Set<TrainingProgram> trainingPrograms;

    @OneToMany(mappedBy = "user")
    private List<Speciality> specialities;

}
