package com.richfitint.jwtsecurity.service.user.impl;

import com.richfitint.jwtsecurity.entity.user.User;
import com.richfitint.jwtsecurity.entity.user.UserRole;
import com.richfitint.jwtsecurity.exceptions.ObjectNotFoundException;
import com.richfitint.jwtsecurity.repository.user.UserRepository;
import com.richfitint.jwtsecurity.service.user.UserRoleService;
import com.richfitint.jwtsecurity.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(
                ()-> new ObjectNotFoundException("Couldn't find user with id " + id));
    }

    @Override
    public User create(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        UserRole userRole = userRoleService.getById(user.getUserRole().getId()); //ROLE_USER
        user.setUserRole(userRole);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User deleteById(Long id) {
        User user = getById(id);
        userRepository.delete(user);
        return user;
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
