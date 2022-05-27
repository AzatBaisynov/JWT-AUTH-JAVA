package com.richfitint.jwtsecurity.service.user.impl;

import com.richfitint.jwtsecurity.entity.user.UserRole;
import com.richfitint.jwtsecurity.exceptions.ObjectNotFoundException;
import com.richfitint.jwtsecurity.repository.user.UserRoleRepository;
import com.richfitint.jwtsecurity.service.user.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole create(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole getById(Long id) {
        return userRoleRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Couldn't find userRole with id " + id));
    }
}
