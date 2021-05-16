package ir.maktab.service.mapper;

import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.dto.ServiceCategoryDto;

public class ServiceCategoryMapper {
    public ServiceCategory toServiceCategory(ServiceCategoryDto serviceCategoryDto){
        return new ServiceCategory()
                .setId(serviceCategoryDto.getId())
                .setName(serviceCategoryDto.getName())
                .setSubCategoryList(serviceCategoryDto.getSubCategoryList())
                .setCustomerOrderList(serviceCategoryDto.getCustomerOrderList())
                .setSpecialistList(serviceCategoryDto.getSpecialistList());
    }
    public ServiceCategoryDto toServiceCategoryDto(ServiceCategory serviceCategory){
        return new ServiceCategoryDto()
                .setId(serviceCategory.getId())
                .setName(serviceCategory.getName())
                .setSubCategoryList(serviceCategory.getSubCategoryList())
                .setCustomerOrderList(serviceCategory.getCustomerOrderList())
                .setSpecialistList(serviceCategory.getSpecialistList());
    }
}
