package ir.maktab.data.repository.cleaningAndHygiene;

import ir.maktab.data.entity.CleaningAndHygiene.SubCleaningAndHygiene;
import ir.maktab.data.entity.moving.SubMoving;

import java.util.List;
import java.util.Optional;


public interface SubCleaningAndHygieneRepository {
    void create(SubCleaningAndHygiene subCleaningAndHygiene);
    void update(SubCleaningAndHygiene subCleaningAndHygiene);
    Optional<SubCleaningAndHygiene> get(Integer id);
    List<SubCleaningAndHygiene> getAll();
    void delete(Integer integer);
}
