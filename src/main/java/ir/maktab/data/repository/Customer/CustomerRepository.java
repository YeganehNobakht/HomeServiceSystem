package ir.maktab.data.repository.Customer;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    void create(Customer customer);
//    void update(Customer customer);
//    Optional<Customer> get(String  id);
//    List<Customer> getAll();
//    void delete(String integer);
//    List<CustomerDto> filterCustomer(CustomerDto customerDto);
    Optional<Customer> findByUsername(String username);

    @Modifying
    @Query("update Customer c set c.Balance = :balance where c.id = :id")
    void updateBalance(@Param("id")Integer id,@Param("balance") double balance);
}