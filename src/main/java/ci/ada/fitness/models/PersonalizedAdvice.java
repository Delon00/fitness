package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "personalized_advice")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalizedAdvice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "dateAdvice", nullable = false)
    private Instant dateAdvice;

    @ManyToOne
    @JoinColumn(name = "routine_id", nullable = false)
    private Routine routine;

}
