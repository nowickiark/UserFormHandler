package com.userForm.UserFormHandler.service;

import com.userForm.UserFormHandler.data.UserDataSet;
import com.userForm.UserFormHandler.model.Person;
import com.userForm.UserFormHandler.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private UserDataSet userDataSet;

    @Autowired
    public UserServiceImpl(UserDataSet userDataSet) {
        this.userDataSet = userDataSet;
    }



    @Override
    public List<UserModel> getUsers() {
        return userDataSet.getUsers();
    }

    @Override
    public UserModel getUserByName(String name) {

        List<UserModel> tempUserList = userDataSet.getUsers();

        Optional<UserModel> matchingUser = tempUserList.stream().filter(a -> a.getUserName().equals(name)).findFirst();

        UserModel matchingUserModel = matchingUser.orElse(null);

        return matchingUserModel;
    }


    public void addUser(UserModel userModel){
        userDataSet.addUser(userModel);
    }

    public boolean doesUserExist(String name){

        boolean result;

        if(getUserByName(name) == null) result = false;
        else result = true;

        return result;
    }

}
