package ir.maktab.service.specialistService;

import ir.maktab.data.entity.Specialist;
import ir.maktab.dto.SpecialistDto;

public interface SpecialistService {

    void create(SpecialistDto specialistDto) throws Exception;

    void delete(String specialistUsername);

    void changePassword(String username, String oldPass,String newPass) throws Exception;

    void update(SpecialistDto specialistDto);
}
