package ir.maktab.dto;

import ir.maktab.data.entity.enums.UserStatus;

import java.util.Date;

public class UserDto {

    private String username;

    private String password;

    private String name;

    private String lastName;

    private String email;

    private UserStatus userStatus;

    private Date date;

    private Double Balance;

    private String userRole;

    public String getUsername() {
        return username;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public UserDto setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public UserDto setDate(Date date) {
        this.date = date;
        return this;
    }

    public Double getBalance() {
        return Balance;
    }

    public UserDto setBalance(Double balance) {
        Balance = balance;
        return this;
    }

    public String getUserRole() {
        return userRole;
    }

    public UserDto setUserRole(String userRole) {
        this.userRole = userRole;
        return this;
    }
}
