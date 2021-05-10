package ir.maktab.data.entity.moving;

import ir.maktab.data.entity.BuildingFacilities.BuildingFacilities;

import javax.persistence.*;

@Entity
public class SubMoving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private String comment;
    @ManyToOne
    @JoinColumn(name="move_furniture", nullable=false)
    private Moving moving;

    public SubMoving() {
    }

    public SubMoving(Integer id, Double price, String comment, Moving moving) {
        this.id = id;
        this.price = price;
        this.comment = comment;
        this.moving = moving;
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
