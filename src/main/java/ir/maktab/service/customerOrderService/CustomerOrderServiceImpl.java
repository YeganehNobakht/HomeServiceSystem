package ir.maktab.service.customerOrderService;

import ir.maktab.data.repository.customerOrder.CustomerOrderRepository;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.CustomerOrderDto;
import ir.maktab.dto.ServiceCategoryDto;
import ir.maktab.dto.SubCategoryDto;
import ir.maktab.service.mapper.CustomerOrderMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerOrderMapper customerOrderMapper;

    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository, CustomerOrderMapper customerOrderMapper) {
        this.customerOrderRepository = customerOrderRepository;
        this.customerOrderMapper = customerOrderMapper;
    }


    @Override
    public void addOrder(CustomerOrderDto customerOrderDto) {
        customerOrderRepository.create(customerOrderMapper.toCustomerOrder(customerOrderDto));
    }

}
