package ir.maktab.service.managerService;


import ir.maktab.dto.*;

import java.util.List;

public interface ManagerService {
    void addSpecialist(SpecialistDto specialistDto) throws Exception;

    void addCustomer(CustomerDto customerDto) throws Exception;

    void deleteSpecialistFromService(String ServiceName, Integer id) throws Exception;

    void editSpecialistFromService(String ServiceName, String SpecialistUsername);

    void addSpecialistToService();

    void addService();

    void addSubService();

    List<ServiceCategoryDto> getServiceCategory();

    List<SubCategoryDto> getSubCategory();

    ManagerDto login(ManagerDto managerDto) throws Exception;
    //List<User>
}
