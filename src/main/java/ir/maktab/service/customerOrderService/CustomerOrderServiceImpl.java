package ir.maktab.service.customerOrderService;

import ir.maktab.data.repository.customerOrder.CustomerOrderRepository;
import ir.maktab.dto.CustomerOrderDto;
import ir.maktab.service.mapper.Mapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

    private final CustomerOrderRepository customerOrderRepository;
    private final Mapper mapper;

    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository, Mapper mapper) {
        this.customerOrderRepository = customerOrderRepository;
        this.mapper = mapper;
    }

    @Override
    public void addOrder(CustomerOrderDto customerOrderDto) {
        customerOrderRepository.save(mapper.toCustomerOrder(customerOrderDto));
    }

}
