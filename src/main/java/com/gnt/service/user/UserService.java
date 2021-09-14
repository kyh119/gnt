package com.gnt.service.user;

import com.gnt.domain.user.User;

public interface UserService {
    User saveUser(User user);
    User getUserById(Long id);
}
