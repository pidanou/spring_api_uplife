package com.uplife.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table (name = "rooms")
public class Room {

    //Attributes

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String campus;

    @NotBlank
    private String name;

    //Constructors

    public Room(){
        super();
    }

    public Room (String campus, String name){
        super();
        this.campus = campus;
        this.name = name;
    }

    //Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
