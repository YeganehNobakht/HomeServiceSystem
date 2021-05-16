package ir.maktab.dto;

import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.data.entity.SubCategory;

import java.util.ArrayList;

import java.util.List;

public class ServiceCategoryDto {

    private Integer id;

    private String name;

    private List<SubCategory> subCategoryList = new ArrayList<>();

    private List<CustomerOrder> customerOrderList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public ServiceCategoryDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ServiceCategoryDto setName(String name) {
        this.name = name;
        return this;
    }

    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    public ServiceCategoryDto setSubCategoryList(List<SubCategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
        return this;
    }

    public List<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }

    public ServiceCategoryDto setCustomerOrderList(List<CustomerOrder> customerOrderList) {
        this.customerOrderList = customerOrderList;
        return this;
    }
}
