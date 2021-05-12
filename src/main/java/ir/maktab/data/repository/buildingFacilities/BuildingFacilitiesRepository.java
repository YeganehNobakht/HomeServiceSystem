package ir.maktab.data.repository.buildingFacilities;

import ir.maktab.data.entity.BuildingFacilities.BuildingFacilities;
import ir.maktab.data.entity.moving.Moving;

import java.util.List;
import java.util.Optional;

public interface BuildingFacilitiesRepository {
    void create(BuildingFacilities buildingFacilities);
    void update(BuildingFacilities buildingFacilities);
    Optional<BuildingFacilities> get(Integer id);
    List<BuildingFacilities> getAll();
    void delete(Integer integer);
}
