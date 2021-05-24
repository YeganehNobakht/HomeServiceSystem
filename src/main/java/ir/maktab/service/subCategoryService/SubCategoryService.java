package ir.maktab.service.subCategoryService;

import ir.maktab.data.entity.SubCategory;
import ir.maktab.dto.ServiceCategoryDto;
import ir.maktab.dto.SubCategoryDto;

public interface SubCategoryService {
    SubCategory get(Integer id) throws Exception;
    SubCategory getByName(String  name) throws Exception;
    void addSubService(ServiceCategoryDto serviceCategoryDto, SubCategoryDto subCategoryDto) throws Exception;
}
