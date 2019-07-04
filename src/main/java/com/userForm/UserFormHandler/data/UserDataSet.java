package com.userForm.UserFormHandler.data;

import com.userForm.UserFormHandler.model.UserModel;

import java.util.List;

public interface UserDataSet {

    List<UserModel> getUsers();
    void addUser(UserModel user);
}
