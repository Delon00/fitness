package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "conseil_personnalise")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalizedAdvice extends BaseEntity implements Serializable {



    @ManyToOne
    @JoinColumn(name = "routine_id", nullable = false)
    private Routine routine;

}
