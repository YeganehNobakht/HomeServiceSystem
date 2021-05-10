package ir.maktab.data.entity.moving;

import ir.maktab.data.entity.BuildingFacilities.BuildingFacilities;

import javax.persistence.*;

@Entity
public class SubMoving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private String name;
    private String comment;
    @ManyToOne
    @JoinColumn(name="move_furniture", nullable=false)
    private Moving moving;

    public SubMoving() {
    }

    public SubMoving(  String name,Double price, String comment) {
        this.price = price;
        this.name = name;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public SubMoving setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public SubMoving setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return name;
    }

    public SubMoving setName(String name) {
        this.name = name;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public SubMoving setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Moving getMoving() {
        return moving;
    }

    public SubMoving setMoving(Moving moving) {
        this.moving = moving;
        return this;
    }
}
