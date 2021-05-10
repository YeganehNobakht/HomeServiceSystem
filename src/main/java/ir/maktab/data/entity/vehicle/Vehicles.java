package ir.maktab.data.entity.vehicle;

import ir.maktab.data.entity.homeAppliances.SubHomeAppliances;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(orphanRemoval = true,cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "vehicles")
    private final List<SubVehicle> subVehicleArrayList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public Vehicles setId(Integer id) {
        this.id = id;
        return this;
    }

    public List<SubVehicle> getSubVehicleArrayList() {
        return subVehicleArrayList;
    }
}
