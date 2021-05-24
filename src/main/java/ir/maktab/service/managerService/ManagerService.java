package ir.maktab.service.managerService;


import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.ServiceCategoryDto;
import ir.maktab.dto.SpecialistDto;
import ir.maktab.dto.SubCategoryDto;

import java.util.List;

public interface ManagerService {
    void addSpecialist(SpecialistDto specialistDto) throws Exception;
    void addCustomer(CustomerDto customerDto) throws Exception;
    void deleteSpecialistFromService(String ServiceName, String SpecialistUsername) throws Exception;
    void editSpecialistFromService(String ServiceName, String SpecialistUsername);
    void addSpecialistToService();
    void addService();
    void addSubService();
    List<ServiceCategoryDto> getServiceCategory();
    List<SubCategoryDto> getSubCategory();
    //List<User>
}
