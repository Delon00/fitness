package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "programme_entraînement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;

    private Integer dureeTotale;

    private String niveauRequis;

    private String objectifProgramme;

    @OneToMany(mappedBy = "programme", cascade = CascadeType.ALL)
    private List<Routine> routines;
}
