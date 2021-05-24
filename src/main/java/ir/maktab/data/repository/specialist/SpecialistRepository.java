package ir.maktab.data.repository.specialist;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.Specialist;
import ir.maktab.dto.SpecialistDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SpecialistRepository extends JpaRepository<Customer,String> {
//    void create(Specialist specialist);
//    void update(Specialist specialist);
//    Optional<Specialist> get(String id);
//    List<Specialist> getAll();
//    void delete(String  username);
//    List<SpecialistDto> filterSpecialist(SpecialistDto specialistDto);
}
