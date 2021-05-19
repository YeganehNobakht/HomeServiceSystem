package ir.maktab.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Specialist extends User{

    @Lob
    @Column(length = 300000,columnDefinition = "BLOB")
    @Basic(fetch = FetchType.LAZY)
    private byte[] profilePicture;

    @ManyToMany
    private List<ServiceCategory> serviceCategoryList = new ArrayList<>();

    @OneToMany(orphanRemoval = true , cascade = CascadeType.PERSIST , mappedBy = "specialist")
    private List<CustomerOrder> customerOrderList = new ArrayList<>();

    @OneToMany(orphanRemoval = true , cascade = CascadeType.PERSIST , mappedBy = "specialist")
    private List<CustomerComment> customerCommentList = new ArrayList<>();


   //constructor


    public Specialist(String username, String password, String name, String lastName, String email) {
        super(username, password, name, lastName, email);
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
