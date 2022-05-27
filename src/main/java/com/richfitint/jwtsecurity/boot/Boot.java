package com.richfitint.jwtsecurity.boot;

import com.richfitint.jwtsecurity.entity.user.User;
import com.richfitint.jwtsecurity.entity.user.UserRole;
import com.richfitint.jwtsecurity.service.user.UserRoleService;
import com.richfitint.jwtsecurity.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Boot implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public void run(String... args) throws Exception {
        UserRole u1 = new UserRole();
        u1.setRole("ROLE_ADMIN");
        UserRole u2 = new UserRole();
        u2.setRole("ROLE_USER");

        UserRole userRole2 = userRoleService.create(u2);
        UserRole userRole = userRoleService.create(u1);

        User user1 = new User();
        user1.setLogin("admin1");
        user1.setPassword("admin1");
        user1.setFullName("Ilzat Isseev");
        user1.setPhone("+78452121245212");
        user1.setUserRole(userRoleService.getById(1L));
        userService.create(user1);

        User user2 = new User();
        user2.setLogin("user1");
        user2.setPassword("user1");
        user2.setFullName("Alex Smith");
        user2.setUserRole(userRoleService.getById(2L));
        userService.create(user2);
    }
}
