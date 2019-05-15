package com.uplife.api.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    //Attributes
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany(mappedBy = "role")
    private Set<User> users;

    //Constructors

    public Role(){super();}

    public Role(String name, Set<User> users) {
        this.name = name;
        this.users = users;
    }

    //Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
