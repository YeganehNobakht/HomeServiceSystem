package ir.maktab.data.repository.specialist;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.Specialist;
import ir.maktab.dto.SpecialistDto;

import java.util.List;
import java.util.Optional;

public interface SpecialistRepository {
    void create(Specialist specialist);
    void update(Specialist specialist);
    Optional<Specialist> get(String id);
    List<Specialist> getAll();
    void delete(String  username);
    List<SpecialistDto> filterSpecialist(SpecialistDto specialistDto);
}
