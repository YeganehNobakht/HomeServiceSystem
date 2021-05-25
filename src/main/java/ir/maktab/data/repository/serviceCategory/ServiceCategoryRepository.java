package ir.maktab.data.repository.serviceCategory;

import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.data.entity.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory,Integer> {
//    void create(ServiceCategory serviceCategory);
//    void update(ServiceCategory serviceCategory);
//    Optional<ServiceCategory> get(Integer id);
//    Optional<ServiceCategory> getByName(String name);
//    List<ServiceCategory> getAll();
//    void delete(Integer integer);
    ServiceCategory findByName(String name);
}
