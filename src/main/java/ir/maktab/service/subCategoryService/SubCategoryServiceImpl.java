package ir.maktab.service.subCategoryService;

import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.data.entity.SubCategory;
import ir.maktab.data.repository.subCategory.SubCategoryRepository;
import ir.maktab.dto.ServiceCategoryDto;
import ir.maktab.dto.SubCategoryDto;
import ir.maktab.service.mapper.SubCategoryMapper;
import ir.maktab.service.serviceCategory.ServiceCategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{

    private final SubCategoryRepository subCategoryRepository;
    private final ServiceCategoryService serviceCategoryService;
    private final SubCategoryMapper subCategoryMapper;


    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository, ServiceCategoryService serviceCategoryService, SubCategoryMapper subCategoryMapper) {
        this.subCategoryRepository = subCategoryRepository;
        this.serviceCategoryService = serviceCategoryService;
        this.subCategoryMapper = subCategoryMapper;
    }

    @Override
    public SubCategory get(Integer id) throws Exception {
        Optional<SubCategory> subCategory = subCategoryRepository.get(id);
        if (subCategory.isPresent())
            return subCategory.get();
        else
            throw new Exception("Service does not exist");
    }

    @Override
    public SubCategory getByName(String name) throws Exception {
        Optional<SubCategory> subCategory = subCategoryRepository.getByName(name);
        if (subCategory.isPresent())
            return subCategory.get();
        else
            throw new Exception("Service does not exist");
    }

    @Override
    public void addSubService(ServiceCategoryDto serviceCategoryDto, SubCategoryDto subCategoryDto) throws Exception {
        ServiceCategory serviceByName = serviceCategoryService.getByName(serviceCategoryDto.getName());
        subCategoryDto.setServiceCategory(serviceByName);
        subCategoryRepository.update(subCategoryMapper.toSubCategory(subCategoryDto));
    }
}
