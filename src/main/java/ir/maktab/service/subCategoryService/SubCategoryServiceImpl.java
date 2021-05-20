package ir.maktab.service.subCategoryService;

import ir.maktab.data.entity.SubCategory;
import ir.maktab.data.repository.subCategory.SubCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
