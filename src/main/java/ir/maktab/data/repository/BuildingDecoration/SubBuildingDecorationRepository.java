package ir.maktab.data.repository.BuildingDecoration;

import ir.maktab.data.entity.BuildingDecoration.BuildingDecoration;
import ir.maktab.data.entity.BuildingDecoration.SubBuildingDecoration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface SubBuildingDecorationRepository {
    void create(SubBuildingDecoration buildingDecoration);
    void update(SubBuildingDecoration buildingDecoration);
    Optional<SubBuildingDecoration> get(Integer id);
    List<SubBuildingDecoration> getAll();
    void delete(Integer integer);
}
