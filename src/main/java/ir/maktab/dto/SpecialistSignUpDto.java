package ir.maktab.dto;

import java.util.List;

/**
 * @author Yeganeh Nobakht
 **/
public class SpecialistSignUpDto {

    private String username;
    private String password;
    private String name;
    private String lastName;
    private String email;
    private String  balance;
    private ServiceCategoryDto serviceCategory;
    private List<ServiceCategoryDto> serviceCategoryDtoList;
    private byte[] profilePicture;


    public String getUsername() {
        return username;
    }

    public SpecialistSignUpDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SpecialistSignUpDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public SpecialistSignUpDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SpecialistSignUpDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SpecialistSignUpDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getBalance() {
        return balance;
    }

    public SpecialistSignUpDto setBalance(String balance) {
        this.balance = balance;
        return this;
    }

    public ServiceCategoryDto getServiceCategory() {
        return serviceCategory;
    }

    public SpecialistSignUpDto setServiceCategory(ServiceCategoryDto serviceCategory) {
        this.serviceCategory = serviceCategory;
        return this;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public SpecialistSignUpDto setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }

    public List<ServiceCategoryDto> getServiceCategoryDtoList() {
        return serviceCategoryDtoList;
    }

    public void addService(ServiceCategoryDto serviceCategoryDto) {
        serviceCategoryDtoList.add(serviceCategoryDto);

    }
}
