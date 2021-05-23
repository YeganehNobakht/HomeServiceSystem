package ir.maktab.service.mapper;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.Specialist;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.SpecialistDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toCustomer(CustomerDto customerDto){
        return new Customer()
                .setBalance(customerDto.getBalance())
                .setDate(customerDto.getDate())
                .setEmail(customerDto.getEmail())
                .setName(customerDto.getName())
                .setLastName(customerDto.getLastName())
                .setPassword(customerDto.getPassword())
                .setUsername(customerDto.getUsername())
                .setUserStatus(customerDto.getUserStatus());

    }
    public CustomerDto toCustomerDto(Customer customer){
        return new CustomerDto()
                .setBalance(customer.getBalance())
                .setDate(customer.getDate())
                .setEmail(customer.getEmail())
                .setName(customer.getName())
                .setLastName(customer.getLastName())
                .setPassword(customer.getPassword())
                .setUsername(customer.getUsername())
                .setUserStatus(customer.getUserStatus());

    }

}
