package com.codegym.lastwhisper.service.user;


import com.codegym.lastwhisper.model.User;
import com.codegym.lastwhisper.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User findByFullName(String username);
    User findByUserName(String username);
}
