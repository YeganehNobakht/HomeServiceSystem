package ir.maktab.service.customerOrderService;

import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.data.entity.enums.OrderStatus;
import ir.maktab.data.repository.customerOrder.CustomerOrderRepository;
import ir.maktab.dto.*;
import ir.maktab.service.mapper.Mapper;
import ir.maktab.service.serviceCategory.ServiceCategoryService;
import ir.maktab.service.subCategoryService.SubCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final Mapper mapper;
    private final ServiceCategoryService categoryService;
    private final SubCategoryService subCategoryService;

    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository, Mapper mapper, ServiceCategoryService categoryService, ir.maktab.service.subCategoryService.SubCategoryService subCategoryService) {
        this.customerOrderRepository = customerOrderRepository;
        this.mapper = mapper;
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
    }

    @Override
    public void addOrder(OrderDto orderDto) throws Exception {
        CustomerOrderDto customerOrderDto = new CustomerOrderDto();

        ServiceCategoryDto serviceByName = categoryService.getByName(orderDto.getServiceCategory());
        SubCategoryDto subServiceByName = subCategoryService.getByName(orderDto.getSubCategory());
        AddressDto addressDto = new AddressDto().setAlley(orderDto.getAlley())
                .setCity(orderDto.getCity()).setStreet(orderDto.getStreet());

//        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(orderDto.getWorkDate());
        customerOrderDto.setServiceCategory(serviceByName)
                .setSubCategory(subServiceByName)
                .setJobDescription(orderDto.getJobDescription())
                .setWorkDate(orderDto.getWorkDate())
                .setAddressDto(addressDto)
                .setCustomerDto(orderDto.getCustomerDto())
                .setOrderStatus(OrderStatus.WAITING_FOR_SPECIALIST_OFFER);

        CustomerOrder customerOrder = mapper.toCustomerOrder(customerOrderDto);
        customerOrderRepository.save(customerOrder);
    }

    @Override
    public List<CustomerOrderDto> findByService(ServiceCategoryDto serviceCategoryDto) throws Exception {
        ServiceCategoryDto service = categoryService.getByName(serviceCategoryDto.getName());
        List<CustomerOrder> customerOrder = customerOrderRepository
                .findByServiceCategoryAndWorkDateGreaterThanEqual(mapper.toServiceCategory(service),new Date());
        return customerOrder.stream().map(mapper::toCustomerOrderDto).collect(Collectors.toList());
    }

    @Override
    public CustomerOrderDto findById(Integer orderId) throws Exception {
        Optional<CustomerOrder> order = customerOrderRepository.findById(orderId);
        if (order.isPresent())
            return mapper.toCustomerOrderDto(order.get());
        throw new  Exception("Wrong Id") ;
    }

    @Override
    public List<CustomerOrderDto> findByCustomer(CustomerDto customerDto) throws Exception {
        List<CustomerOrder> customerOrders = customerOrderRepository.findByCustomer(mapper.toCustomer(customerDto));
//        if (customerOrders.size()==0){
//            throw new Exception("there is no ongoing order");
//        }
        return customerOrders.stream().map(mapper::toCustomerOrderDto).collect(Collectors.toList());
    }

    @Override
    public List<CustomerOrderDto> findByOrderStatusNotAndCustomer_Id(OrderStatus orderStatus, Integer customerId) {
        List<CustomerOrder> customerOrderList = customerOrderRepository.findByOrderStatusNotAndCustomer_Id(orderStatus, customerId);
        return customerOrderList.stream().map(mapper::toCustomerOrderDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void updateOrderStatus(CustomerOrderDto orderDto) throws Exception {
        if (customerOrderRepository.findById(orderDto.getId()).isPresent()) {
            //using save method for update
            customerOrderRepository.updateOrderStatus(orderDto.getId(),orderDto.getOrderStatus());
        } else
            throw new Exception("No such order found");
    }

    @Override
    public List<CustomerOrderDto> findUserByStatusAndCustomer(OrderStatus orderStatus, CustomerDto customerDto) throws Exception {
        List<CustomerOrder> customerOrder = customerOrderRepository.findUserByStatusAndCustomer(orderStatus, customerDto.getId());
        if (customerOrder.size()!=0){
            return customerOrder.stream().map(mapper::toCustomerOrderDto).collect(Collectors.toList());
        }
        else throw new Exception("No such order existed.");
    }


}
