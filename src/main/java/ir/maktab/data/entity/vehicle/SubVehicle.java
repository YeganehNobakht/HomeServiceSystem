package ir.maktab.data.entity.vehicle;

import ir.maktab.data.entity.homeAppliances.HomeAppliances;

import javax.persistence.*;

@Entity
public class SubVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private String name;
    private String comment;
    @ManyToOne
    @JoinColumn(name="vehicles", nullable=false)
    private Vehicles vehicles;

    public SubVehicle() {
    }

    public SubVehicle( String name, Double price, String comment) {
        this.price = price;
        this.name = name;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public SubVehicle setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public SubVehicle setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return name;
    }

    public SubVehicle setName(String name) {
        this.name = name;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public SubVehicle setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    public SubVehicle setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
        return this;
    }
}
