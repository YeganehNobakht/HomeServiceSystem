package ir.maktab.data.entity;

import ir.maktab.data.entity.enums.UserStatus;

import javax.persistence.*;
import java.util.Date;

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "USER_ROLE",discriminatorType = DiscriminatorType.STRING)
public class User {
    @Id
    private String username;

    private String password;

    private String name;

    private String lastName;

    @Column(unique = true)
    private String email;

    @Enumerated
    private UserStatus userStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private Double Balance;

    @Column(name = "USER_RULE", insertable = false, updatable = false)
    private String userRole;

    public User(String username, String password, String name, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public User setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public User setDate(Date date) {
        this.date = date;
        return this;
    }

    public Double getBalance() {
        return Balance;
    }

    public User setBalance(Double balance) {
        Balance = balance;
        return this;
    }

    public String getUserRole() {
        return userRole;
    }
}
