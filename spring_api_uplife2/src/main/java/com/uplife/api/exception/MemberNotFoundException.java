package com.uplife.api.exception;

public class MemberNotFoundException extends Exception{

    private long memberid;

    public MemberNotFoundException(long memberid){
        super(String.format("Member not found with id: '%s'", memberid));
    }
}
