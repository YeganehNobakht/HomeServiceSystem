package ir.maktab.dto;

import ir.maktab.data.entity.Specialist;
import ir.maktab.data.entity.enums.UserStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpecialistDto extends UserDto {
    private double rate;

    private byte[] profilePicture;

    private List<ServiceCategoryDto> serviceCategoryList = new ArrayList<>();

    private List<CustomerCommentDto> customerCommentList = new ArrayList<>();

    private List<SuggestionDto> suggestionList = new ArrayList<>();


    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public SpecialistDto setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }

    public List<ServiceCategoryDto> getServiceCategoryList() {
        return serviceCategoryList;
    }

    public SpecialistDto setServiceCategoryList(List<ServiceCategoryDto> serviceCategoryList) {
        this.serviceCategoryList = serviceCategoryList;
        return this;
    }

    public List<SuggestionDto> getSuggestionList() {
        return suggestionList;
    }

    public SpecialistDto setSuggestionList(List<SuggestionDto> suggestionList) {
        this.suggestionList = suggestionList;
        return this;
    }

    public List<CustomerCommentDto> getCustomerCommentList() {
        return customerCommentList;
    }

    public SpecialistDto setCustomerCommentList(List<CustomerCommentDto> customerCommentList) {
        this.customerCommentList = customerCommentList;
        return this;
    }

    public double getRate() {
        return rate;
    }

    public SpecialistDto setRate(double rate) {
        this.rate = rate;
        return this;
    }

    @Override
    public SpecialistDto setId(Integer id) {
        super.setId(id);
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
