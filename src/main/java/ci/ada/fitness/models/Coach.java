package ci.ada.fitness.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "coach")
@AllArgsConstructor
@NoArgsConstructor
public class Coach implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @OneToMany
    @JoinTable(
            name = "coach_speciality",
            joinColumns =
            @JoinColumn(name = "coach_id"),
            inverseJoinColumns =
            @JoinColumn(name = "speciality_id")
    )
    private Set<Speciality> specialities;

}
