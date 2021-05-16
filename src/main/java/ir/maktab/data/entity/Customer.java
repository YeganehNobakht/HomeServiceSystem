package ir.maktab.data.entity;

import ir.maktab.data.entity.enums.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends User {



    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = "customer", fetch = FetchType.EAGER)
    private final List<CustomerOrder> customerOrderList = new ArrayList<>();

    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = "customer", fetch = FetchType.EAGER)
    private final List<CustomerComment> customerCommentList = new ArrayList<>();

    public Customer(String username, String password, String fullName) {
        super(username, password, fullName);
    }

    public Customer() {
    }

    public List<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }

    public List<CustomerComment> getCustomerCommentList() {
        return customerCommentList;
    }
}
