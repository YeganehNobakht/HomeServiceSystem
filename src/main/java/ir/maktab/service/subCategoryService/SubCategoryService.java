package ir.maktab.service.subCategoryService;

import ir.maktab.data.entity.SubCategory;

public interface SubCategoryService {
    SubCategory get(Integer id) throws Exception;
    SubCategory getByName(String  name) throws Exception;
}
