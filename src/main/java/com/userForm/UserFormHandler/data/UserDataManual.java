package com.userForm.UserFormHandler.data;

import com.userForm.UserFormHandler.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserDataManual implements UserDataSet {

    private List<UserModel> userList;


    public UserDataManual(){
        this.userList = new ArrayList<>();
    }

    @Override
    public List<UserModel> getUsers() {
        return userList;
    }

    @Override
    public void addUser(UserModel user) {
        userList.add(user);
    }
}
