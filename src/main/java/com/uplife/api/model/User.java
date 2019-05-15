package com.uplife.api.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    //Attributes

    @Id
    @GeneratedValue
    private long id;

    private String nom;
    private String prenom;
    private String username;
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany
    Set<Role> role;

    //Constructors

    public User(String nom, String prenom, String username,
                String password, String passwordConfirm, Set<Role> role) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.role = role;
    }

    //Getters and setters

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
