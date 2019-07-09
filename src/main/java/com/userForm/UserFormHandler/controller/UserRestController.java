package com.userForm.UserFormHandler.controller;

import com.userForm.UserFormHandler.model.UserModel;
import com.userForm.UserFormHandler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {

private UserService userService;

@Autowired
public UserRestController (UserService userService){this.userService = userService;}


    @RequestMapping("/userFormPost")
    @ResponseBody
    public UserModel addUserToList(@RequestParam ("name") String name, @RequestParam ("email") String email, @RequestParam("message") String message, Model model ) {


        System.out.println(email);
        System.out.println(name);
        System.out.println(message);

        UserModel formUser;

        if (userService.doesUserExist(name)) {
            formUser = userService.getUserByName(name);
            model.addAttribute("name", "User " + name + " is already registared" + " message was added to his history");
        } else {

            formUser = new UserModel(name, email);
            userService.addUser(formUser);
            model.addAttribute("name", "Registered user " + name + " with message.");
        }

        formUser.addMessage(message);

        return formUser;

    }
}
