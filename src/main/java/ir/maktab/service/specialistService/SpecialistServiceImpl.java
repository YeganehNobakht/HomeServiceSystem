package ir.maktab.service.specialistService;

import ir.maktab.data.entity.Specialist;
import ir.maktab.data.repository.specialist.SpecialistRepository;

public class SpecialistServiceImpl implements SpecialistService{

    private final SpecialistRepository specialistRepository;

    public SpecialistServiceImpl(SpecialistRepository specialistRepository) {
        this.specialistRepository = specialistRepository;
    }

    @Override
    public void create(Specialist specialist) {
        specialistRepository.create(specialist);
    }

    @Override
    public void delete(String specialistUsername) {
        specialistRepository.delete(specialistUsername);
    }
}
