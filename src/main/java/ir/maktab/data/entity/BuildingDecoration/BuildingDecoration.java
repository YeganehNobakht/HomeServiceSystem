package ir.maktab.data.entity.BuildingDecoration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BuildingDecoration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(orphanRemoval = true,cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "buildingDecoration")
    private final List<SubBuildingDecoration> subBuildingDecorationList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public List<SubBuildingDecoration> getSubBuildingDecorationList() {
        return subBuildingDecorationList;
    }
}
