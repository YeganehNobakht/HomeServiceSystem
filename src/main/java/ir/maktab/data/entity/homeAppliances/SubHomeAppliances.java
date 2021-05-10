package ir.maktab.data.entity.homeAppliances;

import ir.maktab.data.entity.CleaningAndHygiene.CleaningAndHygiene;

import javax.persistence.*;

@Entity
public class SubHomeAppliances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private String name;
    private String comment;
    @ManyToOne
    @JoinColumn(name="home_appliances", nullable=false)
    private HomeAppliances homeAppliances;

    public SubHomeAppliances() {
    }

    public SubHomeAppliances( String name,Double price, String comment) {
        this.price = price;
        this.name = name;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public SubHomeAppliances setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public SubHomeAppliances setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return name;
    }

    public SubHomeAppliances setName(String name) {
        this.name = name;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public SubHomeAppliances setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public HomeAppliances getHomeAppliances() {
        return homeAppliances;
    }

    public SubHomeAppliances setHomeAppliances(HomeAppliances homeAppliances) {
        this.homeAppliances = homeAppliances;
        return this;
    }
}
