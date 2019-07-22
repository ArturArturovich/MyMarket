package com.geekbrains.artur.springMarket.service;

import com.geekbrains.artur.springMarket.service.model.SystemUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    SystemUser findById(long id);

    SystemUser findByUserName(String username);

    boolean save(SystemUser systemUser);

    List<SystemUser>findAll();
}
