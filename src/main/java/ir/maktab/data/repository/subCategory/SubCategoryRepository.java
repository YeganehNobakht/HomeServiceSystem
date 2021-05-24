package ir.maktab.data.repository.subCategory;

import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.data.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Integer> {
//    void create(SubCategory subCategory);
//    void update(SubCategory subCategory);
//    Optional<SubCategory> get(Integer id);
//    Optional<SubCategory> getByName(String name);
//    List<SubCategory> getAll();
//    void delete(Integer integer);
}
