package ir.maktab.dto;

import ir.maktab.data.entity.*;
import ir.maktab.data.entity.enums.OrderStatus;

import java.util.Date;

public class CustomerOrderDto {
    private Long id;

    private OrderStatus orderStatus;

    private ServiceCategory serviceCategory;

    private SubCategory subCategory;

    private String jobDescription;

    private Date orderDate;

    private Date workDate;

    private AddressDto addressDto;

    private CustomerDto customerDto;

    private SuggestionDto suggestionDto;

    public Long getId() {
        return id;
    }

    public CustomerOrderDto setId(Long id) {
        this.id = id;
        return this;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public CustomerOrderDto setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public CustomerOrderDto setServiceCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
        return this;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public CustomerOrderDto setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public CustomerOrderDto setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public CustomerOrderDto setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public CustomerOrderDto setWorkDate(Date workDate) {
        this.workDate = workDate;
        return this;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public CustomerOrderDto setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
        return this;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public CustomerOrderDto setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
        return this;
    }

    public SuggestionDto getSuggestionDto() {
        return suggestionDto;
    }

    public CustomerOrderDto setSuggestionDto(SuggestionDto suggestionDto) {
        this.suggestionDto = suggestionDto;
        return this;
    }
}
