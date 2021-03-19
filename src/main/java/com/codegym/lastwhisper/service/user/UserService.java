package com.codegym.lastwhisper.service.user;


import com.codegym.lastwhisper.model.User;
import com.codegym.lastwhisper.model.UserPrinciple;
import com.codegym.lastwhisper.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByFullName(username);
        return UserPrinciple.build(user);
    }

    @Override
    public User findByFullName(String username) {
        return userRepository.findByFullName(username);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findAllByUsername(username);
    }

}
