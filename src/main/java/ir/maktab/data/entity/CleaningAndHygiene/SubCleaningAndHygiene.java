package ir.maktab.data.entity.CleaningAndHygiene;

import ir.maktab.data.entity.moving.Moving;

import javax.persistence.*;

@Entity
public class SubCleaningAndHygiene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private String name;
    private String comment;
    @ManyToOne
    @JoinColumn(name="cleaning", nullable=false)
    private CleaningAndHygiene cleaningAndHygiene;

    public SubCleaningAndHygiene( String name,Double price, String comment) {
        this.price = price;
        this.name = name;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public SubCleaningAndHygiene setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public SubCleaningAndHygiene setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return name;
    }

    public SubCleaningAndHygiene setName(String name) {
        this.name = name;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public SubCleaningAndHygiene setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public CleaningAndHygiene getCleaningAndHygiene() {
        return cleaningAndHygiene;
    }

    public SubCleaningAndHygiene setCleaningAndHygiene(CleaningAndHygiene cleaningAndHygiene) {
        this.cleaningAndHygiene = cleaningAndHygiene;
        return this;
    }
}
