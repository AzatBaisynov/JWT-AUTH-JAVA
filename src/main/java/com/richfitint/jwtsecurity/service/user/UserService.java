package com.richfitint.jwtsecurity.service.user;

import com.richfitint.jwtsecurity.entity.user.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long id);
    User create(User user);
    User update(User user);
    User deleteById(Long id);
    User getByLogin(String login);
}
