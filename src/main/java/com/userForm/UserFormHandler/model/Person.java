package com.userForm.UserFormHandler.model;

import java.util.List;

public interface Person {

    String getUserName();
    String getUserEmail();
    List<String> getMessageList();
    void addMessage( String name);

}
