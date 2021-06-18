package ir.maktab.service.customerService;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.CustomerOrderDto;
import ir.maktab.dto.OrderDto;

import java.util.List;

public interface CustomerService {

    Customer customerSignIn() throws Exception;

    void update(CustomerDto customerDto) throws Exception;

    void changePassword(String username, String oldPass, String newPass) throws Exception;

    void create(CustomerDto customerOrderDto) throws Exception;

    CustomerDto login(CustomerDto customerDto) throws Exception;

    List<CustomerOrderDto> getOrders(CustomerDto customerDto) throws Exception;

    double returnMoney(double price, CustomerDto customerDto);

    void payByAccount(CustomerDto customerDto, double price);
}
