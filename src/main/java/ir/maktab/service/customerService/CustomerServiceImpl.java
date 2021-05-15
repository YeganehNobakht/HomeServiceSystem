package ir.maktab.service.customerService;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.repository.Customer.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final Scanner scanner;

    public CustomerServiceImpl(CustomerRepository customerRepository, Scanner scanner) {
        this.customerRepository = customerRepository;
        this.scanner = scanner;
    }

    @Override
    public void customerSignIn() throws Exception {
        System.out.println("Username");
        String username = scanner.next();
        System.out.println("Password");
        String password = scanner.next();
        Customer customer = fetchCustomerByUsername(username);
        if (customer.getPassword().equals(password)){
            System.out.println("Select a service");
            //TODO :: show service and sub service
        }

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
}
