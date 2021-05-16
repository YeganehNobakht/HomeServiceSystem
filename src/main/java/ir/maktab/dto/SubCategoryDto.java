package ir.maktab.dto;

import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.data.entity.ServiceCategory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class SubCategoryDto {

    private Integer id;

    private String name;

    private ServiceCategory serviceCategory;

    private List<CustomerOrder> customerOrderList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public SubCategoryDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SubCategoryDto setName(String name) {
        this.name = name;
        return this;
    }

    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public SubCategoryDto setServiceCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
        return this;
    }

    public List<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }

    public SubCategoryDto setCustomerOrderList(List<CustomerOrder> customerOrderList) {
        this.customerOrderList = customerOrderList;
        return this;
    }
}
