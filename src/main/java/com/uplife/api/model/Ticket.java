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

    @NotBlank
    private String reponse;

    @NotBlank
    private String message;

    @NotBlank
    private long id_room;

    @NotBlank
    private String subject;

    @NotBlank
    private Date date;

    @NotBlank
    private Long image;


}
