package ir.maktab.dto;

import ir.maktab.data.entity.enums.OrderStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Yeganeh Nobakht
 **/

public class OrderDto {
    private String serviceCategory;
    private String  subCategory;
    private String jobDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date workDate;
    private String city;
    private String street;
    private String alley;
    private CustomerDto customerDto;

    public String getServiceCategory() {
        return serviceCategory;
    }

    public OrderDto setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
        return this;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public OrderDto setSubCategory(String subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public OrderDto setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
        return this;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public OrderDto setWorkDate(Date workDate) {
        this.workDate = workDate;
        return this;
    }

    public String getCity() {
        return city;
    }

    public OrderDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public OrderDto setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getAlley() {
        return alley;
    }

    public OrderDto setAlley(String alley) {
        this.alley = alley;
        return this;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public OrderDto setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
        return this;
    }
}
