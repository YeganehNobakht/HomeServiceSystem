package ir.maktab.data.repository.Customer;

import ir.maktab.data.entity.Customer;
import ir.maktab.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    void create(Customer customer);
    void update(Customer customer);
    Optional<Customer> get(String  id);
    List<Customer> getAll();
    void delete(String integer);
    List<CustomerDto> filterCustomer(CustomerDto customerDto);
}
