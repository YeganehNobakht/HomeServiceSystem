package ir.maktab.service.managerService;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.data.entity.Specialist;
import ir.maktab.dto.ServiceCategoryDto;
import ir.maktab.dto.SubCategoryDto;
import ir.maktab.service.customerService.CustomerService;
import ir.maktab.service.serviceCategory.ServiceCategoryService;
import ir.maktab.service.specialistService.SpecialistService;
import ir.maktab.service.validations.Validations;

import java.util.List;
import java.util.Scanner;

public class managerServiceImpl implements ManagerService{

    private final Scanner scanner;
    private final Validations validations;
    private final CustomerService customerService;
    private final SpecialistService specialistService;
    private final ServiceCategoryService serviceCategoryService;

    public managerServiceImpl(Scanner scanner, Validations validations, CustomerService customerService, SpecialistService specialistService, ServiceCategoryService serviceCategoryService) {
        this.scanner = scanner;
        this.validations = validations;
        this.customerService = customerService;
        this.specialistService = specialistService;
        this.serviceCategoryService = serviceCategoryService;
    }


    @Override
    public void addCustomer() throws Exception {
        int inputNumber = getInputNumber();
        System.out.println("Enter customer information: (username, password, full name, email)");
        for (int i = 0; i < inputNumber; i++) {
        Customer customer = new Customer(scanner.next(), scanner.next(), scanner.next(), scanner.next());
        if (validations.validatePassword(customer.getPassword())
                && validations.validateEmail(customer.getEmail())
                && validations.validateName(customer.getFullName())
                && validations.validateUsername(customer.getUsername())) {

            customerService.create(customer);
        }
    }
}

    @Override
    public void addSpecialist() throws Exception {
        int inputNumber = getInputNumber();
        System.out.println("Enter specialist information: (username, password, full name, email)");
        for (int i = 0; i < inputNumber; i++) {
            Specialist specialist = new Specialist(scanner.next(), scanner.next(), scanner.next(), scanner.next());
            if (validations.validatePassword(specialist.getPassword())
                    && validations.validateEmail(specialist.getEmail())
                    && validations.validateName(specialist.getFullName())
                    && validations.validateUsername(specialist.getUsername())) {

                specialistService.create(specialist);
            }
        }
    }

    @Override
    public void deleteSpecialistFromService(String serviceName, String specialistUsername) throws Exception {
        ServiceCategory service = serviceCategoryService.getByName(serviceName);
        if (service.getSpecialistList().stream().anyMatch(specialist -> specialist.getUsername().equals(specialistUsername)))
            specialistService.delete(specialistUsername);
        else
            throw new Exception("Specialist not found");

    }

    @Override
    public void editSpecialistFromService(String ServiceName, String SpecialistUsername) {

    }

    @Override
    public void addSpecialistToService() {

    }

    @Override
    public void addService() {

    }

    @Override
    public void addSubService() {

    }

    @Override
    public List<ServiceCategoryDto> getServiceCategory() {
        return null;
    }

    @Override
    public List<SubCategoryDto> getSubCategory() {
        return null;
    }


    private int getInputNumber(){
        boolean validInput = false;
        int numberOfInput =0;
        while (!validInput) {
            try {
                System.out.println("Enter number of drivers");
                String strDriverNumber = scanner.next();
                numberOfInput = Integer.parseInt(strDriverNumber);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input type! try again...");
            }
        }
        return numberOfInput;
    }
}
