package ir.maktab.service.customerOrderService;

import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.data.repository.customerOrder.CustomerOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

    private final CustomerOrderRepository customerOrderRepository;

    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    @Override
    public void create(CustomerOrder customerOrder) {
        customerOrderRepository.create(customerOrder);
    }
}
