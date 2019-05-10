package com.uplife.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table (name = "rooms")
public class Room {

    @Id
    @GeneratedValue
    public long id;

    @NotBlank
    public String campus;

    @NotBlank
    public String name;

    public Room(){
        super();
    }

    public Room (String campus, String name){
        super();
        this.campus = campus;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
