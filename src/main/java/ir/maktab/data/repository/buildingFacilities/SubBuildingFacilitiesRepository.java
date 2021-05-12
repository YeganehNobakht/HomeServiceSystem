package ir.maktab.data.repository.buildingFacilities;

import ir.maktab.data.entity.BuildingFacilities.SubBuildingFacilities;
import ir.maktab.data.entity.moving.SubMoving;

import java.util.List;
import java.util.Optional;


public interface SubBuildingFacilitiesRepository {
    void create(SubBuildingFacilities subBuildingFacilities);
    void update(SubBuildingFacilities subBuildingFacilities);
    Optional<SubBuildingFacilities> get(Integer id);
    List<SubBuildingFacilities> getAll();
    void delete(Integer integer);
}
