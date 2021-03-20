package com.c0920i1.lastWishper.service.userdetail;

import com.c0920i1.lastWishper.model.User;
import com.c0920i1.lastWishper.model.UserDetail;
import com.c0920i1.lastWishper.service.IGeneralService;

public interface IUserDetailService extends IGeneralService<UserDetail> {
    UserDetail getUserDetailByUser(User user);
}
