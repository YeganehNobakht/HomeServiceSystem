package ir.maktab.data.repository.customerOrder;

import ir.maktab.data.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Long> {
//    void create(CustomerOrder customerOrder);
//    void update(CustomerOrder customerOrder);
//    Optional<CustomerOrder> get(Integer id);
//    List<CustomerOrder> getAll();
//    void delete(Integer integer);
}
