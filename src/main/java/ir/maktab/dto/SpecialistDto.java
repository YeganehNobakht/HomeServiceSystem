package ir.maktab.dto;

import ir.maktab.data.entity.CustomerComment;
import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.data.entity.ServiceCategory;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
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
}
