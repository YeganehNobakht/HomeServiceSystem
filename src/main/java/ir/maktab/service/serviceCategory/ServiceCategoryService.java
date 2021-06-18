package ir.maktab.service.serviceCategory;

import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.dto.ServiceCategoryDto;
import ir.maktab.dto.SpecialistDto;

import java.util.List;

public interface ServiceCategoryService {
    ServiceCategory get(Integer id) throws Exception;

    ServiceCategoryDto getByName(String name) throws Exception;

    void addServiceCategory(ServiceCategoryDto serviceCategoryDto) throws Exception;

    void updateSpecialist(SpecialistDto specialistDto) throws Exception;

    void deleteSpecialist(ServiceCategoryDto serviceCategoryDto, SpecialistDto specialistDto) throws Exception;

    void addSpecialist(ServiceCategoryDto serviceCategoryDto, SpecialistDto specialistDto) throws Exception;

    void update(ServiceCategoryDto serviceCategoryDto) throws Exception;

    List<ServiceCategoryDto> getAll();

    void delete(ServiceCategoryDto serviceCategoryDto) throws Exception;

    ServiceCategoryDto sava(ServiceCategoryDto serviceCategoryDto);
}
