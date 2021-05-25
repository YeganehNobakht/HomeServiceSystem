package ir.maktab.service.subCategoryService;

import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.data.entity.SubCategory;
import ir.maktab.data.repository.subCategory.SubCategoryRepository;
import ir.maktab.dto.ServiceCategoryDto;
import ir.maktab.dto.SubCategoryDto;
import ir.maktab.service.mapper.SubCategoryMapper;
import ir.maktab.service.serviceCategory.ServiceCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Optional<SubCategory> subCategory = subCategoryRepository.findById(id);
        if (subCategory.isPresent())
            return subCategory.get();
        else
            throw new Exception("Service does not exist");
    }

    @Override
    public SubCategory getByName(String name) throws Exception {
        SubCategory subCategory = subCategoryRepository.findByName(name);
        if (subCategory!=null)
            return subCategory;
        else
            throw new Exception("Service does not exist");
    }

    @Override
    public void addSubService(ServiceCategoryDto serviceCategoryDto, SubCategoryDto subCategoryDto) throws Exception {
        ServiceCategory serviceByName = serviceCategoryService.getByName(serviceCategoryDto.getName());
        subCategoryDto.setServiceCategory(serviceByName);
        //using save method for update
        subCategoryRepository.save(subCategoryMapper.toSubCategory(subCategoryDto));
    }

    @Override
    public void update(SubCategoryDto subCategoryDto) throws Exception {
        Optional<SubCategory> subCategory = subCategoryRepository.findById(subCategoryDto.getId());
        if (subCategory.isPresent()) {
            subCategoryRepository.save(subCategory.get());
        }
        else
            throw new Exception("Subcategory not found");
    }

    @Override
    public List<SubCategoryDto> getAll() {
        List<SubCategory> subCategoryList = subCategoryRepository.findAll();
        return subCategoryList.stream().map(subCategoryMapper::toSubCategoryDto).collect(Collectors.toList());
    }

    @Override
    public void delete(SubCategoryDto subCategoryDto) throws Exception {
        Optional<SubCategory> subCategory = subCategoryRepository.findById(subCategoryDto.getId());
        if (subCategory.isPresent()) {
            subCategoryRepository.delete(subCategory.get());
        }
        else
            throw new Exception("Subcategory not found");
    }
}
