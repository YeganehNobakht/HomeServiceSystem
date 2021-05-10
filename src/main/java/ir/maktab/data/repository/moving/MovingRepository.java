package ir.maktab.data.repository.moving;

import ir.maktab.data.entity.moving.Moving;
import ir.maktab.data.entity.vehicle.Vehicles;

import java.util.List;
import java.util.Optional;

public interface MovingRepository {
    void create(Moving moving);
    void update(Moving moving);
    Optional<Moving> get(Integer id);
    List<Moving> getAll();
    void delete(Integer integer);
}
