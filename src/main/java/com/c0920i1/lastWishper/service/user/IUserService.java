package com.c0920i1.lastWishper.service.user;

import com.c0920i1.lastWishper.model.User;
import com.c0920i1.lastWishper.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User findByUsername(String username);
}
