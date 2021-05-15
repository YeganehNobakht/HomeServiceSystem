package ir.maktab.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ServiceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToMany(orphanRemoval = true , cascade = CascadeType.PERSIST , mappedBy = "serviceCategory" , fetch = FetchType.EAGER)
    private List<SubCategory> subCategoryList = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public ServiceCategory setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ServiceCategory setName(String name) {
        this.name = name;
        return this;
    }

    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

}
