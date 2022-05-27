package com.richfitint.jwtsecurity.repository.user;


import com.richfitint.jwtsecurity.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
