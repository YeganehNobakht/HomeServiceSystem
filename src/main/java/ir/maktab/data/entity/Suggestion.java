package ir.maktab.data.entity;

import javax.persistence.*;

@Entity
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    private String workDescription;

    private String durationOfWork;

    private String startTime;

    @ManyToOne
    @JoinColumn(name="customerOrder_suggestion", nullable=false , foreignKey = @ForeignKey(name = "suggestion_fk"))
    private CustomerOrder customerOrder;

    @ManyToOne
    @JoinColumn(name="specialist_suggestion", nullable=false , foreignKey = @ForeignKey(name = "suggestion_fk"))
    private Specialist specialist;


    public Long getId() {
        return id;
    }

    public Suggestion setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Suggestion setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public Suggestion setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
        return this;
    }

    public String getDurationOfWork() {
        return durationOfWork;
    }

    public Suggestion setDurationOfWork(String durationOfWork) {
        this.durationOfWork = durationOfWork;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public Suggestion setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public Suggestion setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
        return this;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public Suggestion setSpecialist(Specialist specialist) {
        this.specialist = specialist;
        return this;
    }
}
