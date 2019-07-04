package com.userForm.UserFormHandler.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class UserModel implements Person {

    private String name;
    private String email;
    private List<String> messages;

    @Autowired
    public UserModel(String name, String email) {
        this.name = name;
        this.email = email;
        this.messages = new  ArrayList<>();
    }

    public String getUserName() {
        return name;
    }


    public String getUserEmail() {
        return email;
    }


    public List<String> getMessageList() {
        return messages;
    }

    public void addMessage(String message){
        messages.add(message);
    }



}
