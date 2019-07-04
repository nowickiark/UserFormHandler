package com.userForm.UserFormHandler.service;

import com.userForm.UserFormHandler.model.Person;
import com.userForm.UserFormHandler.model.UserModel;


import java.util.List;

public interface UserService {

    List<UserModel> getUsers();
    UserModel getUserByName(String name);
    void addUser(UserModel userModel);
    boolean doesUserExist(String name);

}
