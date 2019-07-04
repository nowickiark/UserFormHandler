package com.userForm.UserFormHandler.controller;

import com.userForm.UserFormHandler.model.Person;
import com.userForm.UserFormHandler.model.UserModel;
import com.userForm.UserFormHandler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/userForm")
    public String addUserToList(@RequestParam ("name") String name, @RequestParam ("email") String email, @RequestParam ("message") String message, Model model ) {
        System.out.println(email);
        System.out.println(name);
        System.out.println(message);

        UserModel formUser;

        if (userService.doesUserExist(name)){
            formUser = userService.getUserByName(name);
            model.addAttribute("name", "User " + name + " is already registared" + " message was added to his history" );
        }
        else {
            formUser = new UserModel(name, email);
            userService.addUser(formUser);
            model.addAttribute("name", "Registered user " + name + " with message." );
        }

        formUser.addMessage(message);

        return "index";
    }

}
