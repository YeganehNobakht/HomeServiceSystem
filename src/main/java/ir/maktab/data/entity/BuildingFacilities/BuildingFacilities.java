package ir.maktab.data.entity.BuildingFacilities;

import ir.maktab.data.entity.BuildingDecoration.SubBuildingDecoration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BuildingFacilities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(orphanRemoval = true,cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "buildingFacilities")
    private final List<SubBuildingFacilities> subBuildingFacilitiesList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public List<SubBuildingFacilities> getSubBuildingFacilitiesList() {
        return subBuildingFacilitiesList;
    }

    public BuildingFacilities setId(Integer id) {
        this.id = id;
        return this;
    }
}
