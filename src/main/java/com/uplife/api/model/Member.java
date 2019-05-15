package com.uplife.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "members")

public class Member {

    @Id
    @GeneratedValue
    public long id;

    @NotBlank
    public String first_name;

    @NotBlank
    public String last_name;

    @NotBlank
    public int status;

    public Member(){
        super();
    }

    public Member (String first_name, String last_name, int status){
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.status = status;
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

    public int getstatus() {
        return status;
    }

    public void setstatus(int status) {
        this.status = status;
    }


}

