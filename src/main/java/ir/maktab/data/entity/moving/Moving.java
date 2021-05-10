package ir.maktab.data.entity.moving;

import ir.maktab.data.entity.BuildingFacilities.SubBuildingFacilities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Moving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(orphanRemoval = true,cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "buildingFacilities")
    private final List<SubMoving> subMovingList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public Moving setId(Integer id) {
        this.id = id;
        return this;
    }

    public List<SubMoving> getSubMovingList() {
        return subMovingList;
    }
}
