package ir.maktab.data.repository.customerOrder;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.data.entity.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {
//    void create(CustomerOrder customerOrder);
//    void update(CustomerOrder customerOrder);
//    Optional<CustomerOrder> get(Integer id);
//    List<CustomerOrder> getAll();
//    void delete(Integer integer);



    List<CustomerOrder> findByServiceCategoryAndWorkDateGreaterThanEqual(ServiceCategory serviceCategory,Date date);
    List<CustomerOrder> findByCustomer(Customer customer);
    @Query("SELECT c FROM CustomerOrder c WHERE c.orderStatus = :status and c.customer.id = :customerId")
    List<CustomerOrder> findUserByStatusAndCustomer(@Param("status") OrderStatus orderStatus, @Param("customerId") Integer customerId);

    @Modifying
    @Query("update CustomerOrder o set o.orderStatus = :orderStatus where o.id = :id")
    void updateOrderStatus(@Param("id") Integer id, @Param("orderStatus") OrderStatus orderStatus);

    List<CustomerOrder> findByOrderStatusNotAndCustomer_Id(OrderStatus orderStatus, Integer customerId);

}
