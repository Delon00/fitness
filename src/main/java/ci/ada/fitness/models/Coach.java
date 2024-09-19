package ci.ada.fitness.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "coach")
@NoArgsConstructor
public class Coach implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "slug", unique = true, nullable = false)
    private String slug;

    @OneToOne
    private Speciality speciality;
}
