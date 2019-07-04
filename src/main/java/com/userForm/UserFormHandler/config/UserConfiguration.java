package com.userForm.UserFormHandler.config;

import com.userForm.UserFormHandler.data.UserDataManual;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {


    @Bean
    public UserDataManual userDataManual(){ return new UserDataManual();
    }

}
