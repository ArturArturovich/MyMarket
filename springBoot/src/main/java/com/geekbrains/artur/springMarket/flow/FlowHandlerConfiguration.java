package com.geekbrains.artur.springMarket.flow;


import com.geekbrains.artur.springMarket.flow.register.UserRegisterHandler;
import com.geekbrains.artur.springMarket.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlowHandlerConfiguration {

    @Bean
    public UserRegisterHandler userRegisterHandler(UserService userService){
        return new UserRegisterHandler(userService);
    }
}
