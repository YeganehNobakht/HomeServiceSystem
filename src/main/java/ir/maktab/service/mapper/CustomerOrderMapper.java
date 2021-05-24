package ir.maktab.service.mapper;

import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.dto.CustomerOrderDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerOrderMapper {
    public CustomerOrder toCustomerOrder(CustomerOrderDto customerOrderDto){
        return new CustomerOrder()
                .setAddress(customerOrderDto.getAddress())
                .setCustomer(customerOrderDto.getCustomer())
                .setOrderDate(customerOrderDto.getOrderDate())
                .setOrderStatus(customerOrderDto.getOrderStatus())
                .setServiceCategory(customerOrderDto.getServiceCategory())
                .setSubCategory(customerOrderDto.getSubCategory())
                .setId(customerOrderDto.getId())
                .setJobDescription(customerOrderDto.getJobDescription())
                .setWorkDate(customerOrderDto.getWorkDate());
    }

    public CustomerOrderDto toCustomerOrderDto(CustomerOrder customerOrder) {
        return new CustomerOrderDto()
                .setAddress(customerOrder.getAddress())
                .setCustomer(customerOrder.getCustomer())
                .setOrderDate(customerOrder.getOrderDate())
                .setOrderStatus(customerOrder.getOrderStatus())
                .setServiceCategory(customerOrder.getServiceCategory())
                .setSubCategory(customerOrder.getSubCategory())
                .setId(customerOrder.getId())
                .setJobDescription(customerOrder.getJobDescription())
                .setWorkDate(customerOrder.getWorkDate());
    }
}
