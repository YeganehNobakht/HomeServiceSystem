package ir.maktab.service.managerService;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.Manager;
import ir.maktab.data.entity.Specialist;
import ir.maktab.data.repository.manager.ManagerRepository;
import ir.maktab.dto.*;
import ir.maktab.service.customerService.CustomerService;
import ir.maktab.service.mapper.ManagerMapper;
import ir.maktab.service.serviceCategory.ServiceCategoryService;
import ir.maktab.service.specialistService.SpecialistService;
import ir.maktab.service.validations.Validations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class managerServiceImpl implements ManagerService {

    private final Validations validations;
    private final CustomerService customerService;
    private final SpecialistService specialistService;
    private final ServiceCategoryService serviceCategoryService;
    private final ManagerMapper managerMapper;
    private final ManagerRepository managerRepository;

    public managerServiceImpl(Validations validations, CustomerService customerService, SpecialistService specialistService, ServiceCategoryService serviceCategoryService, ManagerMapper managerMapper, ManagerRepository managerRepository) {
        this.validations = validations;
        this.customerService = customerService;
        this.specialistService = specialistService;
        this.serviceCategoryService = serviceCategoryService;
        this.managerMapper = managerMapper;
        this.managerRepository = managerRepository;
    }


    @Override
    public void addCustomer(CustomerDto customerDto) throws Exception {
        Customer customer = new Customer(customerDto.getUsername(), customerDto.getPassword(), customerDto.getName(), customerDto.getLastName(), customerDto.getEmail());
        if (validations.validatePassword(customer.getPassword())
                && validations.validateEmail(customer.getEmail())
                && validations.validateName(customer.getName())
                && validations.validateName(customer.getLastName())
                && validations.validateUsername(customer.getUsername())) {

            customerService.create(customerDto);
        }
    }


    @Override
    public void addSpecialist(SpecialistDto specialistDto) throws Exception {

        //TODO :: correct it
        Specialist specialist = new Specialist(specialistDto.getUsername(), specialistDto.getPassword(), specialistDto.getName(), specialistDto.getLastName(), specialistDto.getEmail());
        if (validations.validatePassword(specialist.getPassword())
                && validations.validateEmail(specialist.getEmail())
                && validations.validateName(specialist.getName())
                && validations.validateName(specialist.getLastName())
                && validations.validateUsername(specialist.getUsername())) {

            //specialistService.create(specialistDto);
        }

    }

    @Override
    public void deleteSpecialistFromService(String serviceName, Integer id) throws Exception {
        ServiceCategoryDto service = serviceCategoryService.getByName(serviceName);
        if (service.getSpecialistList().stream().anyMatch(specialist -> specialist.getId().equals(id)))
            specialistService.delete(id);
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

    @Override
    public ManagerDto login(ManagerDto managerDto) throws Exception {
        Optional<Manager> manager = managerRepository.findByUsernameAndPassword(managerDto.getUsername(),managerDto.getPassword());
        if (manager.isPresent()) {
           return managerMapper.toManagerDto(manager.get());
        }
        throw new Exception("manager is not registered");
    }


//    private int getInputNumber(){
//        boolean validInput = false;
//        int numberOfInput =0;
//        while (!validInput) {
//            try {
//                System.out.println("Enter number of drivers");
//                String strDriverNumber = scanner.next();
//                numberOfInput = Integer.parseInt(strDriverNumber);
//                validInput = true;
//            } catch (NumberFormatException e) {
//                System.out.println("Wrong input type! try again...");
//            }
//        }
//        return numberOfInput;
//    }
}
