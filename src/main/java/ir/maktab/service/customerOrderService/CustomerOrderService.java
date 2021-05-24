package ir.maktab.service.customerOrderService;

import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.CustomerOrderDto;
import ir.maktab.dto.ServiceCategoryDto;
import ir.maktab.dto.SubCategoryDto;

public interface CustomerOrderService {
    void addOrder(CustomerOrderDto customerOrderDto);

}
