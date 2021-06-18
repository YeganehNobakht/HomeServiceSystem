package ir.maktab.service.customerOrderService;

import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.data.entity.enums.OrderStatus;
import ir.maktab.dto.*;

import java.util.List;

public interface CustomerOrderService {
    void addOrder(OrderDto orderDto) throws Exception;

    List<CustomerOrderDto> findByService(ServiceCategoryDto serviceCategoryDto) throws Exception;
    CustomerOrderDto findById(Integer orderId) throws Exception;
    List<CustomerOrderDto> findByCustomer(CustomerDto customerDto) throws Exception;
    List<CustomerOrderDto> findByOrderStatusNotAndCustomer_Id(OrderStatus orderStatus , Integer customerId);
    void updateOrderStatus(CustomerOrderDto orderDto) throws Exception;
    List<CustomerOrderDto> findUserByStatusAndCustomer(OrderStatus orderStatus, CustomerDto customerDto) throws Exception;

}
