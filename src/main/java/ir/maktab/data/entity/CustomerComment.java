package ir.maktab.data.entity;

import javax.persistence.*;

@Entity
public class CustomerComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String comment;

    private Double score;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false , foreignKey = @ForeignKey(name = "customer_comment_fk"))
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="specialist_id", nullable=false , foreignKey = @ForeignKey(name = "specialist_comment_fk"))
    private Specialist specialist;


    public Integer getId() {
        return id;
    }

    public CustomerComment setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public CustomerComment setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public CustomerComment setScore(Double score) {
        this.score = score;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CustomerComment setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public CustomerComment setSpecialist(Specialist specialist) {
        this.specialist = specialist;
        return this;
    }
}
