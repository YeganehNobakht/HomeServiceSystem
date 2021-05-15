package ir.maktab.data.repository.serviceCategory;

import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.data.entity.ServiceCategory;

import java.util.List;
import java.util.Optional;

public interface ServiceCategoryRepository {
    void create(ServiceCategory serviceCategory);
    void update(ServiceCategory serviceCategory);
    Optional<ServiceCategory> get(Integer id);
    Optional<ServiceCategory> getByName(String name);
    List<ServiceCategory> getAll();
    void delete(Integer integer);
}
