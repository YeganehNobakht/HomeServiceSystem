package ir.maktab.dto;

import ir.maktab.data.entity.CustomerComment;
import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.data.entity.enums.UserStatus;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDto extends UserDto {
    private final List<CustomerOrder> customerOrderList = new ArrayList<>();

    private final List<CustomerComment> customerCommentList = new ArrayList<>();

    public List<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }

    public List<CustomerComment> getCustomerCommentList() {
        return customerCommentList;
    }

        @Override
    public CustomerDto setUsername(String username) {
        super.setUsername(username);
        return this;
    }

    @Override
    public CustomerDto setPassword(String password) {
        super.setPassword(password);
        return this;
    }

    @Override
    public CustomerDto setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public CustomerDto setLastName(String lastName) {
        super.setLastName(lastName);
        return this;
    }

    @Override
    public CustomerDto setEmail(String email) {
        super.setEmail(email);
        return this;
    }

    @Override
    public CustomerDto setUserStatus(UserStatus userStatus) {
        super.setUserStatus(userStatus);
        return this;
    }

    @Override
    public CustomerDto setDate(Date date) {
        super.setDate(date);
        return this;
    }

    @Override
    public CustomerDto setBalance(Double balance) {
        super.setBalance(balance);
        return this;
    }

    @Override
    public CustomerDto setUserRole(String userRole) {
        super.setUserRole(userRole);
        return this;
    }
}
