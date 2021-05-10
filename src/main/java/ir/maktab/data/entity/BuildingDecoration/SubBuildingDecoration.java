package ir.maktab.data.entity.BuildingDecoration;

import ir.maktab.data.entity.BuildingDecoration.BuildingDecoration;

import javax.persistence.*;

public class SubBuildingDecoration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private String comment;
    @ManyToOne
    @JoinColumn(name="building_decoration", nullable=false)
    private BuildingDecoration buildingDecoration;

    public SubBuildingDecoration(Integer id, Double price, String comment, BuildingDecoration buildingDecoration) {
        this.id = id;
        this.price = price;
        this.comment = comment;
        this.buildingDecoration = buildingDecoration;
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
