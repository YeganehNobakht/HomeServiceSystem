package ir.maktab.dto;

import ir.maktab.data.entity.CustomerComment;
import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.data.entity.enums.UserStatus;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpecialistDto extends UserDto{

    private byte[] profilePicture;

    private String specialty;

    private List<ServiceCategory> serviceCategoryList = new ArrayList<>();
//
//    private List<CustomerOrder> customerOrderList = new ArrayList<>();
//
//    private List<CustomerComment> customerCommentList = new ArrayList<>();



    public String getSpecialty() {
        return specialty;
    }

    public SpecialistDto setSpecialty(String specialty) {
        this.specialty = specialty;
        return this;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public SpecialistDto setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }

    public List<ServiceCategory> getServiceCategoryList() {
        return serviceCategoryList;
    }

    public SpecialistDto setServiceCategoryList(List<ServiceCategory> serviceCategoryList) {
        this.serviceCategoryList = serviceCategoryList;
        return this;
    }

    @Override
    public SpecialistDto setUsername(String username) {
        super.setUsername(username);
        return this;
    }

    @Override
    public SpecialistDto setPassword(String password) {
        super.setPassword(password);
        return this;
    }

    @Override
    public SpecialistDto setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public SpecialistDto setLastName(String lastName) {
        super.setLastName(lastName);
        return this;
    }

    @Override
    public SpecialistDto setEmail(String email) {
        super.setEmail(email);
        return this;
    }

    @Override
    public SpecialistDto setUserStatus(UserStatus userStatus) {
        super.setUserStatus(userStatus);
        return this;
    }

    @Override
    public SpecialistDto setDate(Date date) {
        super.setDate(date);
        return this;
    }

    @Override
    public SpecialistDto setUserRole(String userRole) {
        super.setUserRole(userRole);
        return this;
    }

    @Override
    public SpecialistDto setBalance(Double balance) {
        super.setBalance(balance);
        return this;
    }
}
