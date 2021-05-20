package ir.maktab.service.mapper;

import ir.maktab.data.entity.SubCategory;
import ir.maktab.dto.SubCategoryDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SubCategoryMapper {
    public SubCategoryDto toSubCategoryDto(SubCategory subCategory) {
        return new SubCategoryDto()
                .setId(subCategory.getId())
                .setName(subCategory.getName())
                .setCustomerOrderList(subCategory.getCustomerOrderList())
                .setServiceCategory(subCategory.getServiceCategory());
    }

    public SubCategory toSubCategory(SubCategoryDto subCategoryDto) {
        return new SubCategory()
                .setId(subCategoryDto.getId())
                .setName(subCategoryDto.getName())
                .setCustomerOrderList(subCategoryDto.getCustomerOrderList())
                .setServiceCategory(subCategoryDto.getServiceCategory());
    }
}
