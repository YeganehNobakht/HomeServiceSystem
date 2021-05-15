package ir.maktab.data.repository.specialist;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.Specialist;

import java.util.List;
import java.util.Optional;

public interface SpecialistRepository {
    void create(Specialist specialist);
    void update(Specialist specialist);
    Optional<Specialist> get(Integer id);
    List<Specialist> getAll();
    void delete(Integer integer);
}
