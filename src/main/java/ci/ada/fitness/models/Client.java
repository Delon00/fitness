package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client extends User {

    @Column(name = "level", nullable = false)
    private String level;

    @Column(name = "objective", nullable = false)
    private String objective;

    @OneToMany
    private List<Routine> routines;

    @OneToMany
    private Set<TrainingProgram> trainingPrograms;
}
