package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "exercise")
@AllArgsConstructor
@NoArgsConstructor
public class Exercise extends BaseEntity implements Serializable {


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;
    // Other fields and relationships

}
