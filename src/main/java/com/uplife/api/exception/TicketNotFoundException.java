package com.uplife.api.exception;

public class TicketNotFoundException extends Exception{

    private long ticket_id;

    public TicketNotFoundException(long ticket_id){
        super(String.format("Room not found with id: '%s'", ticket_id));
    }

}
