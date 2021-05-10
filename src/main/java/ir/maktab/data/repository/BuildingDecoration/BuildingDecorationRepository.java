package ir.maktab.data.repository.BuildingDecoration;

import ir.maktab.data.entity.BuildingDecoration.BuildingDecoration;
import ir.maktab.data.entity.BuildingDecoration.SubBuildingDecoration;

import java.util.List;
import java.util.Optional;

public interface BuildingDecorationRepository {
    void create(BuildingDecoration buildingDecoration);
    void update(BuildingDecoration buildingDecoration);
    Optional<BuildingDecoration> get(Integer id);
    List<BuildingDecoration> getAll();
    void delete(Integer integer);
}
