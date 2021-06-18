package ir.maktab.service.serviceCategory;

import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.data.entity.Specialist;
import ir.maktab.data.entity.SubCategory;
import ir.maktab.data.repository.serviceCategory.ServiceCategoryRepository;
import ir.maktab.dto.ServiceCategoryDto;
import ir.maktab.dto.SpecialistDto;
import ir.maktab.service.mapper.Mapper;
import ir.maktab.service.specialistService.SpecialistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceCategoryServiceImpl implements ServiceCategoryService {

    private final ServiceCategoryRepository serviceCategoryRepository;
    private final Mapper mapper;
    private final SpecialistService specialistService;

    public ServiceCategoryServiceImpl(ServiceCategoryRepository serviceCategoryRepository, Mapper mapper, SpecialistService specialistService) {
        this.serviceCategoryRepository = serviceCategoryRepository;
        this.mapper = mapper;
        this.specialistService = specialistService;
    }


    @Override
    public ServiceCategory get(Integer id) throws Exception {
        Optional<ServiceCategory> serviceCategory = serviceCategoryRepository.findById(id);
        if (serviceCategory.isPresent())
            return serviceCategory.get();
        else
            throw new Exception("Service does not exist");
    }

    @Override
    public ServiceCategoryDto getByName(String name) throws Exception {
        ServiceCategory serviceCategory = serviceCategoryRepository.findByName(name);
        if (serviceCategory != null)
            return mapper.toServiceCategoryDto(serviceCategory);
        else
            throw new Exception("Service does not exist");
    }

    @Override
    public void addServiceCategory(ServiceCategoryDto serviceCategoryDto) throws Exception {
        if (serviceCategoryRepository.findByName(serviceCategoryDto.getName()) != null) {
            throw new Exception("Duplicate service");
        } else {
            serviceCategoryRepository.save(mapper.toServiceCategory(serviceCategoryDto));
        }
    }

    @Override
    public void updateSpecialist(SpecialistDto specialistDto) throws Exception {
        specialistService.update(specialistDto);
    }

    @Override
    public void deleteSpecialist(ServiceCategoryDto serviceCategoryDto, SpecialistDto specialistDto) throws Exception {
        Specialist specialist = mapper.toSpecialist(specialistDto);
        ServiceCategoryDto serviceCategory = getByName(serviceCategoryDto.getName());

        serviceCategory.getSpecialistList().remove(specialist);
        //using save method for update
        serviceCategoryRepository.save(mapper.toServiceCategory(serviceCategory));

        specialist.getServiceCategoryList().remove(serviceCategory);
        specialistService.update(mapper.toSpecialistDto(specialist));
    }

    @Override
    public void addSpecialist(ServiceCategoryDto serviceCategoryDto, SpecialistDto specialistDto) throws Exception {

        Specialist specialist = mapper.toSpecialist(specialistDto);
        ServiceCategoryDto serviceCategory = getByName(serviceCategoryDto.getName());

        serviceCategoryDto.getSpecialistList().add(mapper.toSpecialistDto(specialist));
        //using save method for update
        serviceCategoryRepository.save(mapper.toServiceCategory(serviceCategory));

        specialist.getServiceCategoryList().add(mapper.toServiceCategory(serviceCategory));
        specialistService.update(mapper.toSpecialistDto(specialist));
    }

    @Override
    public void update(ServiceCategoryDto serviceCategoryDto) throws Exception {
        Optional<ServiceCategory> serviceCategoryRepositoryById = serviceCategoryRepository.findById(serviceCategoryDto.getId());
        if (serviceCategoryRepositoryById.isPresent()) {
            serviceCategoryRepository.save(serviceCategoryRepositoryById.get());
        } else
            throw new Exception("Service category not found");
    }

    @Override
    public List<ServiceCategoryDto> getAll() {
        List<ServiceCategory> subCategoryList = serviceCategoryRepository.findAll();
        return subCategoryList.stream().map(mapper::toServiceCategoryDto).collect(Collectors.toList());
    }

    @Override
    public void delete(ServiceCategoryDto serviceCategoryDto) throws Exception {
        Optional<ServiceCategory> serviceCategory = serviceCategoryRepository.findById(serviceCategoryDto.getId());
        if (serviceCategory.isPresent()) {
            serviceCategoryRepository.delete(serviceCategory.get());
        } else
            throw new Exception("Service category not found");
    }

    @Override
    public ServiceCategoryDto sava(ServiceCategoryDto serviceCategoryDto) {
        ServiceCategory serviceCategory = serviceCategoryRepository.save(mapper.toServiceCategory(serviceCategoryDto));
        return mapper.toServiceCategoryDto(serviceCategory);
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
