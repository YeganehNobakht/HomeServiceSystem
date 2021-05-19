package ir.maktab.service.specialistService;

import ir.maktab.data.entity.Specialist;
import ir.maktab.data.repository.specialist.SpecialistRepository;
import ir.maktab.service.validations.Validations;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecialistServiceImpl implements SpecialistService{

    private final SpecialistRepository specialistRepository;
    private final Validations validations;

    public SpecialistServiceImpl(SpecialistRepository specialistRepository, Validations validations) {
        this.specialistRepository = specialistRepository;
        this.validations = validations;
    }


    @Override
    public void create(Specialist specialist) {
        specialistRepository.create(specialist);
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
}
