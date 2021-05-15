package ir.maktab.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Specialist {
    @Id
    private String username;

    private String password;

    private String fullName;

    @Column(unique = true)
    private String email;

    @Enumerated
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private Double Balance;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] profilePicture;

    @OneToMany(orphanRemoval = true , cascade = CascadeType.PERSIST , mappedBy = "serviceCategory" , fetch = FetchType.EAGER)
    private List<ServiceCategory> serviceCategoryList = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public Specialist setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Specialist setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Specialist setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Specialist setEmail(String email) {
        this.email = email;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Specialist setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Specialist setDate(Date date) {
        this.date = date;
        return this;
    }

    public Double getBalance() {
        return Balance;
    }

    public Specialist setBalance(Double balance) {
        Balance = balance;
        return this;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public Specialist setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }

}
