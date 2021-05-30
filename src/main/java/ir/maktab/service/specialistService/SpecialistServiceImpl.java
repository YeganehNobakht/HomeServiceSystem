package ir.maktab.service.specialistService;

import ir.maktab.data.entity.Specialist;
import ir.maktab.data.repository.specialist.SpecialistRepository;
import ir.maktab.dto.SpecialistDto;
import ir.maktab.service.mapper.Mapper;
import ir.maktab.service.validations.Validations;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecialistServiceImpl implements SpecialistService{

    private final SpecialistRepository specialistRepository;
    private final Validations validations;
    private final Mapper mapper;

    public SpecialistServiceImpl(SpecialistRepository specialistRepository, Validations validations, Mapper mapper) {
        this.specialistRepository = specialistRepository;
        this.validations = validations;
        this.mapper = mapper;
    }

    @Override
    public void create(SpecialistDto specialistDto) throws Exception {
        Optional<Specialist> specialist1 = specialistRepository.findById(specialistDto.getUsername());
        if (specialist1.isPresent()){
            throw new Exception("Duplicate user");
        }
        else {
            Specialist specialist = mapper.toSpecialist(specialistDto);
            specialistRepository.save(specialist);
        }
    }

    @Override
    public void delete(String specialistUsername) {
        specialistRepository.deleteById(specialistUsername);
    }

    @Override
    public void changePassword(String username, String oldPass,String newPass) throws Exception {
        Optional<Specialist> specialist = specialistRepository.findById(username);
        if (specialist.isPresent()) {
            if (specialist.get().getPassword().equals(oldPass)) {
                if (validations.validatePassword(newPass)) {
                    specialist.get().setPassword(newPass);
                    //using save method for update
                    specialistRepository.save(specialist.get());
                }
            }
        }
    }

    @Override
    public void update(SpecialistDto specialistDto) throws Exception {
        if (specialistRepository.findById(specialistDto.getUsername()).isPresent()){
            //using save method for update
            specialistRepository.save(mapper.toSpecialist(specialistDto));
        }
        else
            throw new Exception("No such specialist found");
    }

    @Override
    public SpecialistDto get(String username) throws Exception {
        Optional<Specialist> specialist = specialistRepository.findById(username);
        if (specialist.isPresent())
            return mapper.toSpecialistDto(specialist.get());
        else
            throw new Exception("No such specialist found");

    }



}
