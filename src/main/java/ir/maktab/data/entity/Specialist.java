package ir.maktab.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Specialist extends User{

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] profilePicture;

    @ManyToMany
    private List<ServiceCategory> serviceCategoryList = new ArrayList<>();

    @OneToMany(orphanRemoval = true , cascade = CascadeType.PERSIST , mappedBy = "serviceCategory" , fetch = FetchType.EAGER)
    private List<CustomerOrder> customerOrderList = new ArrayList<>();

    @OneToMany(orphanRemoval = true , cascade = CascadeType.PERSIST , mappedBy = "serviceCategory" , fetch = FetchType.EAGER)
    private List<CustomerComment> customerCommentList = new ArrayList<>();


   //constructor


    public Specialist(String username, String password, String fullName, String email) {
        super(username, password, fullName, email);
    }

    public Specialist(){

    }

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

    public List<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }


    public List<CustomerComment> getCustomerCommentList() {
        return customerCommentList;
    }


}
