package com.uplife.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private Long author_id;


}
