package ir.maktab.service.subCategoryService;

import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.data.entity.SubCategory;
import ir.maktab.data.repository.subCategory.SubCategoryRepository;

import java.util.Optional;

public class SubCategoryServiceImpl implements SubCategoryService{

    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
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
}
