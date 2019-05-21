package com.uplife.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table (name = "tickets")
public class Ticket {



    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private Long author_id;

    @NotBlank
    private int statut_ticket;

    private String reponse;

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public void setStatut_ticket(int statut_ticket) {
        this.statut_ticket = statut_ticket;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setroom_name(String room_name) {
        this.room_name = room_name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @NotBlank
    private String message;

    @NotBlank
    private String room_name;

    @NotBlank
    private String subject;

    @NotBlank
    private Date date;

    private String image;

    public Long getId() {
        return id;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public int getStatut_ticket() {
        return statut_ticket;
    }

    public String getReponse() {
        return reponse;
    }

    public String getMessage() {
        return message;
    }

    public String getroom_name() {
        return room_name;
    }

    public String getSubject() {
        return subject;
    }

    public Date getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

}
