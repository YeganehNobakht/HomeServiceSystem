package ir.maktab.service.customerService;

import ir.maktab.data.entity.*;
import ir.maktab.data.entity.enums.OrderStatus;
import ir.maktab.data.repository.Customer.CustomerRepository;
import ir.maktab.service.customerOrderService.CustomerOrderService;
import ir.maktab.service.serviceCategory.ServiceCategoryService;
import ir.maktab.service.subCategoryService.SubCategoryService;
import ir.maktab.service.validations.Validations;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final Scanner scanner;
    private final ServiceCategoryService serviceCategoryService;
    private final SubCategoryService subCategoryService;
    private final CustomerOrderService customerOrderService;
    private final Validations validations;

    public CustomerServiceImpl(CustomerRepository customerRepository, Scanner scanner,
                               ServiceCategoryService serviceCategoryService,
                               SubCategoryService subCategoryService,
                               CustomerOrderService customerOrderService,
                               Validations validations) {
        this.customerRepository = customerRepository;
        this.scanner = scanner;
        this.serviceCategoryService = serviceCategoryService;
        this.subCategoryService = subCategoryService;
        this.customerOrderService = customerOrderService;
        this.validations = validations;
    }

    @Override
    public Customer customerSignIn() throws Exception {
        System.out.println("Username");
        String username = scanner.next();
        System.out.println("Password");
        String password = scanner.next();
        Customer customer = fetchCustomerByUsername(username);
        if (customer.getPassword().equals(password)){
            System.out.println("You are successfully sign in");
            return customer;
        }
        else
            throw new Exception("Incorrect password");

    }

    @Override
    public void addOrder(Customer customer) throws Exception {
        System.out.println("Select a service");
        showServices();
        registerOrder(customer);
    }



    private Customer fetchCustomerByUsername(String username) throws Exception {
        Optional<Customer> customer = customerRepository.get(username);
        if (customer.isPresent()){
            System.out.println("Welcome " + customer.get().getFullName());
            return customer.get();
        }
        else
            throw new Exception("User is not registered");
    }

    private void showServices(){
        List<ServiceCategory> all = serviceCategoryService.getAll();
        for (ServiceCategory serviceCategory : all){
            System.out.println(serviceCategory.getName());
            serviceCategory.getSubCategoryList().stream()
                    .filter(s->s.getServiceCategory().equals(serviceCategory.getName()))
                    .forEach(s-> System.out.println("    - " + s.getName()));
        }
    }

    private void registerOrder(Customer customer) throws Exception {
        System.out.println("\n\nChose a service:");
        System.out.println("Example: service/subservice");
        String[] customerInput = scanner.next().split("/");
        if (customerInput.length!=2)
            throw new Exception("Invalid input");
        ServiceCategory serviceCategory = serviceCategoryService.getByName(customerInput[0]);
        SubCategory subCategory = subCategoryService.getByName(customerInput[1]);

        System.out.println("Enter your Address");
        System.out.println("Example: Tehran Valiasr Narges6");
        String city = scanner.next();
        String  street = scanner.next();
        String alley = scanner.next();

        Address address = new Address().setCity(city).setStreet(street).setAlley(alley);

        CustomerOrder customerOrder= new CustomerOrder().setCustomer(customer)
                            .setOrderDate(new Date())
                            .setAddress(address)
                            .setServiceCategory(serviceCategory)
                            .setSubCategory(subCategory)
                            .setOrderStatus(OrderStatus.WAITING_FOR_SPECIALIST_OFFER);
        customerOrderService.create(customerOrder);
    }

    @Override
    public void changePassword(Customer customer) throws Exception {
        System.out.println("Enter old password:");
        Object oldPassword = scanner.next();
        System.out.println("Enter new password:");
        String newPassword = scanner.next();
        if (customer.getPassword().equals(oldPassword)) {
            if (validations.validatePassword(newPassword)) {
                customer.setPassword(newPassword);
                customerRepository.update(customer);
            }
        }

    }

    @Override
    public void create(Customer customer) {
        customerRepository.create(customer);
    }
}
