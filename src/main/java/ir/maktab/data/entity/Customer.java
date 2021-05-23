package ir.maktab.data.entity;

import ir.maktab.data.entity.enums.OrderStatus;
import ir.maktab.data.entity.enums.UserStatus;
import ir.maktab.dto.CustomerDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer extends User {



    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = "customer", fetch = FetchType.EAGER)
    private final List<CustomerOrder> customerOrderList = new ArrayList<>();

    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = "customer")
    private final List<CustomerComment> customerCommentList = new ArrayList<>();


    public Customer(String username, String password, String name, String lastName, String email) {
        super(username, password, name, lastName, email);
    }

    public Customer() {
    }

    public List<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }

    public List<CustomerComment> getCustomerCommentList() {
        return customerCommentList;
    }


    @Override
    public Customer setUsername(String username) {
        super.setUsername(username);
        return this;
    }

    @Override
    public Customer setPassword(String password) {
        super.setPassword(password);
        return this;
    }

    @Override
    public Customer setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public Customer setLastName(String lastName) {
        super.setLastName(lastName);
        return this;
    }

    @Override
    public Customer setEmail(String email) {
        super.setEmail(email);
        return this;
    }

    @Override
    public Customer setUserStatus(UserStatus userStatus) {
        super.setUserStatus(userStatus);
        return this;
    }

    @Override
    public Customer setDate(Date date) {
        super.setDate(date);
        return this;
    }

    @Override
    public Customer setBalance(Double balance) {
        super.setBalance(balance);
        return this;
    }
}
