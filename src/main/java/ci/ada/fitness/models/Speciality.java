package ci.ada.fitness.models;

import jakarta.persistence.Column;

import java.io.Serializable;

public class Speciality extends BaseEntity implements Serializable {

    @Column(name = "name", nullable = false)
    private String name;
}
