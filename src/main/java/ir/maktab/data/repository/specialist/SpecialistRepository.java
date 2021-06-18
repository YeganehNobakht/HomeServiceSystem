package ir.maktab.data.repository.specialist;

import ir.maktab.data.entity.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialist, Integer> {
//    void create(Specialist specialist);
//    void update(Specialist specialist);
//    Optional<Specialist> get(String id);
//    List<Specialist> getAll();
//    void delete(String  username);
//    List<SpecialistDto> filterSpecialist(SpecialistDto specialistDto);



    Optional<Specialist> findByEmailAndUsername(String email,String username);

    Optional<Specialist> findByUsernameAndPassword(String username, String Password);
}
