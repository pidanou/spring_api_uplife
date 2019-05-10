package com.uplife.api.exception;

public class RoomNotFoundException extends Exception{

    private long room_id;

    public RoomNotFoundException(long book_id){
        super(String.format("Room not found with id: '%s'", book_id));
    }

}
