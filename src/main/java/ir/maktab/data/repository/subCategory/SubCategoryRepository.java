package ir.maktab.data.repository.subCategory;

import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.data.entity.SubCategory;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository {
    void create(SubCategory subCategory);
    void update(SubCategory subCategory);
    Optional<SubCategory> get(Integer id);
    List<SubCategory> getAll();
    void delete(Integer integer);
}
