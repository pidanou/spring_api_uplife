package com.uplife.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "members")

public class Member {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String username;

    @NotBlank
    private String first_name;

    @NotBlank
    private String last_name;

    @NotBlank
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany
    private Set<Role> roles;

    public Member(){
        super();
    }

    public Member(@NotBlank String username, @NotBlank String first_name, @NotBlank String last_name,
                  @NotBlank String password, String passwordConfirm, Set<Role> roles) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

