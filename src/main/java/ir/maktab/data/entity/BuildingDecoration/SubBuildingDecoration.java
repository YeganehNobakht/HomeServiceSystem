package ir.maktab.data.entity.BuildingDecoration;

import ir.maktab.data.entity.BuildingDecoration.BuildingDecoration;

import javax.persistence.*;

public class SubBuildingDecoration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private String name;
    private String comment;
    @ManyToOne
    @JoinColumn(name="building_decoration", nullable=false)
    private BuildingDecoration buildingDecoration;

    public SubBuildingDecoration( String name,Double price, String comment) {

        this.price = price;
        this.name = name;
        this.comment = comment;
    }

    public SubBuildingDecoration setId(Integer id) {
        this.id = id;
        return this;
    }

    public SubBuildingDecoration() {
    }

    public Integer getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public SubBuildingDecoration setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return name;
    }

    public SubBuildingDecoration setName(String name) {
        this.name = name;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public SubBuildingDecoration setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public BuildingDecoration getBuildingDecoration() {
        return buildingDecoration;
    }

    public SubBuildingDecoration setBuildingDecoration(BuildingDecoration buildingDecoration) {
        this.buildingDecoration = buildingDecoration;
        return this;
    }
}
