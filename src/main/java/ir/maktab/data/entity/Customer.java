package ir.maktab.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer {
    @Id
    private String username;

    private String fullName;

    @Column(unique = true)
    private String email;

    @Enumerated
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private Double Balance;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = "customer", fetch = FetchType.EAGER)
    private final List<CustomerOrder> customerOrderList = new ArrayList<>();


    public Customer(String username, String fullName, String email) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
    }

    public Customer() {
    }

    public String getUsername() {
        return username;
    }

    public Customer setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Customer setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Customer setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Customer setDate(Date date) {
        this.date = date;
        return this;
    }

    public Double getBalance() {
        return Balance;
    }

    public Customer setBalance(Double balance) {
        Balance = balance;
        return this;
    }

    public List<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }
}
