package ir.maktab.service.specialistService;

import ir.maktab.dto.SpecialistDto;
import ir.maktab.dto.SpecialistSignUpDto;

public interface SpecialistService {

    SpecialistDto create(SpecialistSignUpDto specialistDto) throws Exception;

    void delete(Integer id);

//    void changePassword(String username, String oldPass, String newPass) throws Exception;

    void update(SpecialistDto specialistDto) throws Exception;

//    SpecialistDto get(String username) throws Exception;

    SpecialistDto login(SpecialistDto specialistDto) throws Exception;
}
