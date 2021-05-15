package ir.maktab.data.repository.customerOrder;

import ir.maktab.data.entity.CustomerOrder;

import java.util.List;
import java.util.Optional;

public interface CustomerOrderRepository {
    void create(CustomerOrder customerOrder);
    void update(CustomerOrder customerOrder);
    Optional<CustomerOrder> get(Integer id);
    List<CustomerOrder> getAll();
    void delete(Integer integer);
}
