package ir.maktab.service.serviceCategory;

import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.data.entity.Specialist;
import ir.maktab.data.repository.serviceCategory.ServiceCategoryRepository;
import ir.maktab.dto.ServiceCategoryDto;
import ir.maktab.dto.SpecialistDto;
import ir.maktab.service.mapper.ServiceCategoryMapper;
import ir.maktab.service.mapper.SpecialistMapper;
import ir.maktab.service.specialistService.SpecialistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCategoryServiceImpl implements ServiceCategoryService {

    private final ServiceCategoryRepository serviceCategoryRepository;
    private final SpecialistMapper specialistMapper;
    private final ServiceCategoryMapper serviceCategoryMapper;
    private final SpecialistService specialistService;

    public ServiceCategoryServiceImpl(ServiceCategoryRepository serviceCategoryRepository, SpecialistMapper specialistMapper, ServiceCategoryMapper serviceCategoryMapper, SpecialistService specialistService) {
        this.serviceCategoryRepository = serviceCategoryRepository;
        this.specialistMapper = specialistMapper;
        this.serviceCategoryMapper = serviceCategoryMapper;
        this.specialistService = specialistService;
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

    @Override
    public void addServiceCategory(ServiceCategoryDto serviceCategoryDto) throws Exception {
        if (serviceCategoryRepository.getByName(serviceCategoryDto.getName()).isPresent()){
            throw new Exception("Duplicate service");
        }
        else {
            serviceCategoryRepository.create(serviceCategoryMapper.toServiceCategory(serviceCategoryDto));
        }
    }

    @Override
    public void updateSpecialist(SpecialistDto specialistDto) throws Exception {

    }

    @Override
    public void deleteSpecialist(ServiceCategoryDto  serviceCategoryDto, SpecialistDto specialistDto) throws Exception {
        Specialist specialist = specialistMapper.toSpecialist(specialistDto);
        ServiceCategory serviceCategory = getByName(serviceCategoryDto.getName());

        serviceCategory.getSpecialistList().remove(specialist);
        serviceCategoryRepository.update(serviceCategory);

        specialist.getServiceCategoryList().remove(serviceCategory);
        specialistService.update(specialistMapper.toSpecialistDto(specialist));
    }

    @Override
    public void addSpecialist(ServiceCategoryDto  serviceCategoryDto, SpecialistDto specialistDto) throws Exception {

        Specialist specialist = specialistMapper.toSpecialist(specialistDto);
        ServiceCategory serviceCategory = getByName(serviceCategoryDto.getName());

        serviceCategory.getSpecialistList().add(specialist);
        serviceCategoryRepository.update(serviceCategory);

        specialist.getServiceCategoryList().add(serviceCategory);
        specialistService.update(specialistMapper.toSpecialistDto(specialist));
    }

//    @Override
//    public void updateSpecialist(ServiceCategoryDto serviceCategoryDto, SpecialistDto specialistDto) throws Exception {
////        ServiceCategory serviceCategory = serviceCategoryMapper.toServiceCategory(serviceCategoryDto);
////        Specialist specialist = specialistMapper.toSpecialist(specialistDto);
////        if (serviceCategory.getSpecialistList().stream().anyMatch(specialist1 -> specialist1.getUsername().equals(specialist.getUsername()))){
////
////        }
//        if (specialistService.get(specialistDto.getUsername())!=null){
//            specialistService.update(specialistDto);
//        }
//        specialistService.update(specialistDto);
//
//    }




}
