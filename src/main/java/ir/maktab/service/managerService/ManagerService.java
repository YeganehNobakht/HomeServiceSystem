package ir.maktab.service.managerService;


import ir.maktab.dto.ServiceCategoryDto;
import ir.maktab.dto.SubCategoryDto;
import ir.maktab.service.subCategoryService.SubCategoryService;

import java.util.List;

public interface ManagerService {
    void addCustomer() throws Exception;
    void addSpecialist() throws Exception;
    void deleteSpecialistFromService(String ServiceName, String SpecialistUsername) throws Exception;
    void editSpecialistFromService(String ServiceName, String SpecialistUsername);
    void addSpecialistToService();
    void addService();
    void addSubService();
    List<ServiceCategoryDto> getServiceCategory();
    List<SubCategoryDto> getSubCategory();
    //List<User>
}
