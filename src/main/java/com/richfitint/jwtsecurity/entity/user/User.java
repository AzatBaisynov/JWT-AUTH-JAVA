package com.richfitint.jwtsecurity.entity.user;

import com.richfitint.jwtsecurity.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Column(name = "login", unique = true, nullable = false)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "user_phone")
    private String phone;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole userRole;

    public User() {
    }

    public User(String login, String password, String email, String fullName, String phone, UserRole userRole) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.userRole = userRole;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
