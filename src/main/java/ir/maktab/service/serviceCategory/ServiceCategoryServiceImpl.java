package ir.maktab.service.serviceCategory;

import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.data.repository.serviceCategory.ServiceCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCategoryServiceImpl implements ServiceCategoryService {

    private final ServiceCategoryRepository serviceCategoryRepository;

    public ServiceCategoryServiceImpl(ServiceCategoryRepository serviceCategoryRepository) {
        this.serviceCategoryRepository = serviceCategoryRepository;
    }

    @Override
    public List<ServiceCategory> getAll() {
        return serviceCategoryRepository.getAll();
    }

    @Override
    public ServiceCategory get(Integer id) throws Exception {
        Optional<ServiceCategory> serviceCategory = serviceCategoryRepository.get(id);
        if (serviceCategory.isPresent())
            return serviceCategory.get();
        else
            throw new Exception("Service does not exist");
    }

    @Override
    public ServiceCategory getByName(String name) throws Exception {
        Optional<ServiceCategory> serviceCategory = serviceCategoryRepository.getByName(name);
        if (serviceCategory.isPresent())
            return serviceCategory.get();
        else
            throw new Exception("Service does not exist");
    }
}
