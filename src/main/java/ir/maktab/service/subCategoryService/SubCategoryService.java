package ir.maktab.service.subCategoryService;

import ir.maktab.data.entity.SubCategory;
import ir.maktab.dto.ServiceCategoryDto;
import ir.maktab.dto.SubCategoryDto;

import java.util.List;

public interface SubCategoryService {
    SubCategory get(Integer id) throws Exception;

    SubCategoryDto getByName(String name) throws Exception;

    void addSubService(ServiceCategoryDto serviceCategoryDto, SubCategoryDto subCategoryDto) throws Exception;

    void update(SubCategoryDto subCategoryDto) throws Exception;

    List<SubCategoryDto> getAll();

    void delete(SubCategoryDto subCategoryDto) throws Exception;

    List<String> getByServiceName(String serviceName);

    SubCategoryDto sava(SubCategoryDto subCategoryDto);
}
