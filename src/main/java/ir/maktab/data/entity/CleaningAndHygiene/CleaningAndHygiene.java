package ir.maktab.data.entity.CleaningAndHygiene;

import ir.maktab.data.entity.moving.SubMoving;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CleaningAndHygiene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(orphanRemoval = true,cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "cleaningAndHygiene")
    private final List<SubCleaningAndHygiene> subCleaningAndHygieneArrayList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public CleaningAndHygiene setId(Integer id) {
        this.id = id;
        return this;
    }

    public List<SubCleaningAndHygiene> getSubCleaningAndHygieneArrayList() {
        return subCleaningAndHygieneArrayList;
    }
}
