package com.uplife.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "members")

public class Member {

    /*modifier role*/

    @Id
    @GeneratedValue
    public long id;


    private String username;
    private String password;

    @NotBlank
    private String first_name;

    @NotBlank
    private String last_name;

    private int status;

    @Transient
    private String passwordConfirm;

    public Member(){
        super();
    }

    public Member (String first_name, String last_name, int status, String username,
                   String password, String passwordConfirm){
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.status = status;
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfirst_name() {
        return first_name;
    }

    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getlast_name() {
        return last_name;
    }

    public void setlast_name(String last_name) {
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


}

