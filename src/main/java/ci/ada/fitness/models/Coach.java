package ci.ada.fitness.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coach extends User implements Serializable {


    @Column(name = "specialty", nullable = false)
    private String specialty;


    @OneToMany
    private List<User> users;
}
