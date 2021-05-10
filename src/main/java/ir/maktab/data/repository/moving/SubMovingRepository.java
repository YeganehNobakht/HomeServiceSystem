package ir.maktab.data.repository.moving;

import ir.maktab.data.entity.moving.SubMoving;
import ir.maktab.data.entity.vehicle.SubVehicle;

import java.util.List;
import java.util.Optional;


public interface SubMovingRepository {
    void create(SubMoving subMoving);
    void update(SubMoving subMoving);
    Optional<SubMoving> get(Integer id);
    List<SubMoving> getAll();
    void delete(Integer integer);
}
