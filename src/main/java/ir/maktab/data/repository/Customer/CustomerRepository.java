package ir.maktab.data.repository.Customer;

import ir.maktab.data.entity.Customer;
import ir.maktab.dto.CustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
//    void create(Customer customer);
//    void update(Customer customer);
//    Optional<Customer> get(String  id);
//    List<Customer> getAll();
//    void delete(String integer);
//    List<CustomerDto> filterCustomer(CustomerDto customerDto);
}
