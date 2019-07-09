package com.userForm.UserFormHandler.controller;

import com.userForm.UserFormHandler.model.UserModel;
import com.userForm.UserFormHandler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @RequestMapping("/")
    @ResponseBody
    public List<UserModel> showUsers(){
        return userService.getUsers();
    }

    @RequestMapping("/userForm")
    public String userFormView(Model model){
        model.addAttribute("name","");
        return "index";
    }

}
