package ir.maktab.service.customerService;

import ir.maktab.data.entity.Customer;

public interface CustomerService {

    Customer customerSignIn() throws Exception;

    void addOrder(Customer customer) throws Exception;

    void changePassword(String username, String oldPass,String newPass) throws Exception;

    void create(Customer customer);
}
