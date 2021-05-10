package ir.maktab.data.repository.buildingDecoration;

import ir.maktab.data.entity.BuildingDecoration.SubBuildingDecoration;

import java.util.List;
import java.util.Optional;


public interface SubBuildingDecorationRepository {
    void create(SubBuildingDecoration buildingDecoration);
    void update(SubBuildingDecoration buildingDecoration);
    Optional<SubBuildingDecoration> get(Integer id);
    List<SubBuildingDecoration> getAll();
    void delete(Integer integer);
}
