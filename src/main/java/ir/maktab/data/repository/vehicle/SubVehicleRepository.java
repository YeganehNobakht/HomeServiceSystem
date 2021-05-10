package ir.maktab.data.repository.vehicle;

import ir.maktab.data.entity.BuildingDecoration.SubBuildingDecoration;
import ir.maktab.data.entity.vehicle.SubVehicle;
import ir.maktab.data.entity.vehicle.Vehicles;

import java.util.List;
import java.util.Optional;


public interface SubVehicleRepository {
    void create(SubVehicle vehicles);
    void update(SubVehicle vehicles);
    Optional<SubVehicle> get(Integer id);
    List<SubVehicle> getAll();
    void delete(Integer integer);
}
