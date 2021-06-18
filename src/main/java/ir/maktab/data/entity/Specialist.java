package ir.maktab.data.entity;

import ir.maktab.data.entity.enums.UserStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Specialist extends User {
    private double rate;
    @Lob
    @Column(length = 300000, columnDefinition = "BLOB")
    @Basic(fetch = FetchType.LAZY)
    private byte[] profilePicture;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "specialist_service",
            joinColumns = {@JoinColumn(name = "specialist_id")},
            inverseJoinColumns = {@JoinColumn(name = "service_id")}
    )
    private List<ServiceCategory> serviceCategoryList = new ArrayList<>();

    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = "specialist")
    private List<CustomerComment> customerCommentList = new ArrayList<>();

    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = "specialist")
    private List<Suggestion> suggestionList = new ArrayList<>();

//    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, mappedBy = "specialist")
//    private List<CustomerOrder> customerOrderList = new ArrayList<>();

    public Specialist(String username, String password, String name, String lastName, String email) {
        super(username, password, name, lastName, email);
    }

    public Specialist() {

    }


    @Override
    public Specialist setId(Integer id) {
        super.setId(id);
        return this;
    }

    public double getRate() {
        return rate;
    }

    public Specialist setRate(double rate) {
        this.rate = rate;
        return this;
    }

//    public List<CustomerOrder> getCustomerOrderList() {
//        return customerOrderList;
//    }
//
//    public Specialist setCustomerOrderList(List<CustomerOrder> customerOrderList) {
//        this.customerOrderList = customerOrderList;
//        return this;
//    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public Specialist setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }

    public List<ServiceCategory> getServiceCategoryList() {
        return serviceCategoryList;
    }

    public Specialist setServiceCategoryList(List<ServiceCategory> serviceCategoryList) {
        this.serviceCategoryList = serviceCategoryList;
        return this;
    }

    public List<CustomerComment> getCustomerCommentList() {
        return customerCommentList;
    }

    public Specialist setCustomerCommentList(List<CustomerComment> customerCommentList) {
        this.customerCommentList = customerCommentList;
        return this;
    }

    @Override
    public Specialist setUsername(String username) {
        super.setUsername(username);
        return this;
    }

    @Override
    public Specialist setPassword(String password) {
        super.setPassword(password);
        return this;
    }

    @Override
    public Specialist setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public Specialist setLastName(String lastName) {
        super.setLastName(lastName);
        return this;
    }

    @Override
    public Specialist setEmail(String email) {
        super.setEmail(email);
        return this;
    }

    @Override
    public Specialist setUserStatus(UserStatus userStatus) {
        super.setUserStatus(userStatus);
        return this;
    }

    @Override
    public Specialist setDate(Date date) {
        super.setDate(date);
        return this;
    }

    @Override
    public Specialist setBalance(Double balance) {
        super.setBalance(balance);
        return this;
    }

    public List<Suggestion> getSuggestionList() {
        return suggestionList;
    }

    public Specialist setSuggestionList(List<Suggestion> suggestionList) {
        this.suggestionList = suggestionList;
        return this;
    }
}
