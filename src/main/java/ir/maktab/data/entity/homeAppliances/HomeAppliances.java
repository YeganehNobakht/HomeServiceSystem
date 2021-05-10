package ir.maktab.data.entity.homeAppliances;

import ir.maktab.data.entity.CleaningAndHygiene.SubCleaningAndHygiene;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HomeAppliances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(orphanRemoval = true,cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "homeAppliances")
    private final List<SubHomeAppliances> subHomeAppliancesList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public HomeAppliances setId(Integer id) {
        this.id = id;
        return this;
    }

    public List<SubHomeAppliances> getSubHomeAppliancesList() {
        return subHomeAppliancesList;
    }
}
