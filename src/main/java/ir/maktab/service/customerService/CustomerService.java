package ir.maktab.service.customerService;

import ir.maktab.data.entity.Customer;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.CustomerOrderDto;

public interface CustomerService {

    Customer customerSignIn() throws Exception;

    void addOrder(CustomerOrderDto customerDto) ;

    void changePassword(String username, String oldPass,String newPass) throws Exception;

    void create(CustomerDto customerOrderDto) throws Exception;
}
