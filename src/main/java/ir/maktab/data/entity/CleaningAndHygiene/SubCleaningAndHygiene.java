package ir.maktab.data.entity.CleaningAndHygiene;

import ir.maktab.data.entity.moving.Moving;

import javax.persistence.*;

@Entity
public class SubCleaningAndHygiene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private String comment;
    @ManyToOne
    @JoinColumn(name="cleaning", nullable=false)
    private CleaningAndHygiene cleaningAndHygiene;

    public SubCleaningAndHygiene(Integer id, Double price, String comment, CleaningAndHygiene cleaningAndHygiene) {
        this.id = id;
        this.price = price;
        this.comment = comment;
        this.cleaningAndHygiene = cleaningAndHygiene;
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
