package com.c0920i1.lastWishper.repository;

import com.c0920i1.lastWishper.model.User;
import com.c0920i1.lastWishper.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDetailRepository extends JpaRepository<UserDetail,Long> {
    UserDetail getUserDetailByUser(User user);
}
