package com.c0920i1.lastWishper.service.userdetail;

import com.c0920i1.lastWishper.model.User;
import com.c0920i1.lastWishper.model.UserDetail;
import com.c0920i1.lastWishper.repository.IUserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements IUserDetailService {

    @Autowired
    private IUserDetailRepository iUserDetailRepository;

    @Override
    public Optional<UserDetail> findById(Long id) {
        return iUserDetailRepository.findById(id);
    }

    @Override
    public Iterable<UserDetail> findAll() {
        return iUserDetailRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        iUserDetailRepository.deleteById(id);
    }

    @Override
    public UserDetail save(UserDetail guest) {
        return iUserDetailRepository.save(guest);
    }

    @Override
    public UserDetail getUserDetailByUser(User user) {
        return iUserDetailRepository.getUserDetailByUser(user);
    }
}
