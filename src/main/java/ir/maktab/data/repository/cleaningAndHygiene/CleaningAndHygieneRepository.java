package ir.maktab.data.repository.cleaningAndHygiene;

import ir.maktab.data.entity.CleaningAndHygiene.CleaningAndHygiene;
import ir.maktab.data.entity.moving.Moving;

import java.util.List;
import java.util.Optional;

public interface CleaningAndHygieneRepository {
    void create(CleaningAndHygiene cleaningAndHygiene);
    void update(CleaningAndHygiene cleaningAndHygiene);
    Optional<CleaningAndHygiene> get(Integer id);
    List<CleaningAndHygiene> getAll();
    void delete(Integer integer);
}
