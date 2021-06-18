package ir.maktab.service.specialistService;

import ir.maktab.data.entity.Specialist;
import ir.maktab.data.repository.specialist.SpecialistRepository;
import ir.maktab.dto.ServiceCategoryDto;
import ir.maktab.dto.SpecialistDto;
import ir.maktab.dto.SpecialistSignUpDto;
import ir.maktab.service.mapper.Mapper;
import ir.maktab.service.serviceCategory.ServiceCategoryService;
import ir.maktab.service.validations.Validations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SpecialistServiceImpl implements SpecialistService {

    private final SpecialistRepository specialistRepository;
    private final Validations validations;
    private final Mapper mapper;

    public SpecialistServiceImpl(SpecialistRepository specialistRepository, Validations validations, Mapper mapper) {
        this.specialistRepository = specialistRepository;
        this.validations = validations;
        this.mapper = mapper;
    }

    @Override
    public SpecialistDto create(SpecialistSignUpDto specialistSignUpDto) throws Exception {
        SpecialistDto specialistDto = new SpecialistDto()
                .setName(specialistSignUpDto.getName())
                .setEmail(specialistSignUpDto.getEmail())
                .setLastName(specialistSignUpDto.getLastName())
                .setUsername(specialistSignUpDto.getUsername())
                .setPassword(specialistSignUpDto.getPassword())
                .setProfilePicture(specialistSignUpDto.getProfilePicture());



        Optional<Specialist> specialist1 = specialistRepository.findByEmailAndUsername(specialistDto.getEmail(),specialistDto.getUsername());
        if (specialist1.isPresent()) {
            throw new Exception("Duplicate Email Or Username");
        } else {
            Specialist specialist = specialistRepository.save(mapper.toSpecialist(specialistDto));
            specialist.getServiceCategoryList().add(mapper.toServiceCategory(specialistSignUpDto.getServiceCategory()));
            specialistRepository.save(specialist);
            return mapper.toSpecialistDto(specialist);
        }
    }

    @Override
    public void delete(Integer id) {
        specialistRepository.deleteById(id);
    }

//    @Override
//    public void changePassword(String username, String oldPass, String newPass) throws Exception {
//        Optional<Specialist> specialist = specialistRepository.findById(username);
//        if (specialist.isPresent()) {
//            if (specialist.get().getPassword().equals(oldPass)) {
//                if (validations.validatePassword(newPass)) {
//                    specialist.get().setPassword(newPass);
//                    //using save method for update
//                    specialistRepository.save(specialist.get());
//                }
//            }
//        }
//    }

    @Override
    public void update(SpecialistDto specialistDto) throws Exception {
        if (specialistRepository.findById(specialistDto.getId()).isPresent()) {
            //using save method for update
            specialistRepository.save(mapper.toSpecialist(specialistDto));
        } else
            throw new Exception("No such specialist found");
    }

//    @Override
//    public SpecialistDto get(String username) throws Exception {
//        Optional<Specialist> specialist = specialistRepository.findById(username);
//        if (specialist.isPresent())
//            return mapper.toSpecialistDto(specialist.get());
//        else
//            throw new Exception("No such specialist found");
//
//    }

    @Transactional
    @Override
    public SpecialistDto login(SpecialistDto specialistDto) throws Exception {
        Optional<Specialist> byUsernameAndPassword = specialistRepository.findByUsernameAndPassword(specialistDto.getUsername(), specialistDto.getPassword());
        if (byUsernameAndPassword.isPresent())
            return mapper.toSpecialistDto(byUsernameAndPassword.get());
        throw new Exception("No such specialist found");
    }


}
