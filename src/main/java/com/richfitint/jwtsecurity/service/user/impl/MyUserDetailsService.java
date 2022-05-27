package com.richfitint.jwtsecurity.service.user.impl;

import com.richfitint.jwtsecurity.entity.user.User;
import com.richfitint.jwtsecurity.entity.user.UserRole;
import com.richfitint.jwtsecurity.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        List<UserRole> roles = new ArrayList<>();
        roles.add(user.getUserRole());
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);
    }
}