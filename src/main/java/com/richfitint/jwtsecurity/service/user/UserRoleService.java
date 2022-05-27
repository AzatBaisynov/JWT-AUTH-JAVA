package com.richfitint.jwtsecurity.service.user;

import com.richfitint.jwtsecurity.entity.user.UserRole;

public interface UserRoleService {
    UserRole create(UserRole userRole);
    UserRole getById(Long id);
}
