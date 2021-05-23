package ir.maktab.service.specialistService;

import ir.maktab.data.entity.Specialist;
import ir.maktab.data.repository.specialist.SpecialistRepository;
import ir.maktab.dto.SpecialistDto;
import ir.maktab.service.mapper.SpecialistMapper;
import ir.maktab.service.validations.Validations;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecialistServiceImpl implements SpecialistService{

    private final SpecialistRepository specialistRepository;
    private final Validations validations;
    private final SpecialistMapper specialistMapper;

    public SpecialistServiceImpl(SpecialistRepository specialistRepository, Validations validations, SpecialistMapper specialistMapper) {
        this.specialistRepository = specialistRepository;
        this.validations = validations;
        this.specialistMapper = specialistMapper;
    }

    @Override
    public void create(SpecialistDto specialistDto) throws Exception {
        Optional<Specialist> specialist1 = specialistRepository.get(specialistDto.getUsername());
        if (specialist1.isPresent()){
            throw new Exception("Duplicate user");
        }
        else {
            Specialist specialist = specialistMapper.toSpecialist(specialistDto);
            specialistRepository.create(specialist);
        }
    }

    @Override
    public void delete(String specialistUsername) {
        specialistRepository.delete(specialistUsername);
    }

    @Override
    public void changePassword(String username, String oldPass,String newPass) throws Exception {
        Optional<Specialist> specialist = specialistRepository.get(username);
        if (specialist.isPresent()) {
            if (specialist.get().getPassword().equals(oldPass)) {
                if (validations.validatePassword(newPass)) {
                    specialist.get().setPassword(newPass);
                    specialistRepository.update(specialist.get());
                }
            }
        }
    }

    @Override
    public void update(SpecialistDto specialistDto) throws Exception {
        if (specialistRepository.get(specialistDto.getUsername()).isPresent()){
            specialistRepository.update(specialistMapper.toSpecialist(specialistDto));
        }
        else
            throw new Exception("No such specialist found");
    }

    @Override
    public SpecialistDto get(String username) throws Exception {
        Optional<Specialist> specialist = specialistRepository.get(username);
        if (specialist.isPresent())
            return specialistMapper.toSpecialistDto(specialist.get());
        else
            throw new Exception("No such specialist found");
    }


}
