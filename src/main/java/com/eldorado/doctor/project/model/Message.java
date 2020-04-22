package com.eldorado.doctor.project.model;

import lombok.Data;

@Data
public class Message {

    private String message;

    private int code;

    public Message(){}

    public Message(String message, int code){
        this.message = message;
        this.code = code;
    }

}
