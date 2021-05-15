package ir.maktab.service.serviceCategory;

import ir.maktab.data.entity.ServiceCategory;

import java.util.List;

public interface ServiceCategoryService {
    List<ServiceCategory> getAll();
    ServiceCategory get(Integer id) throws Exception;
    ServiceCategory getByName(String name) throws Exception;
}
