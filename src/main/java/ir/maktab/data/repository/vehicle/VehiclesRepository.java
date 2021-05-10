package ir.maktab.data.repository.vehicle;

import ir.maktab.data.entity.BuildingDecoration.BuildingDecoration;
import ir.maktab.data.entity.vehicle.Vehicles;

import java.util.List;
import java.util.Optional;

public interface VehiclesRepository {
    void create(Vehicles vehicles);
    void update(Vehicles vehicles);
    Optional<Vehicles> get(Integer id);
    List<Vehicles> getAll();
    void delete(Integer integer);
}
