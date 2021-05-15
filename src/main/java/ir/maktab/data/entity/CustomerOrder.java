package ir.maktab.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition="varchar(100)")
    private String jobDescription;

    private Double price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;

    private Address address;

    @ManyToOne
    @JoinColumn(name="customer_order", nullable=false , foreignKey = @ForeignKey(name = "customer_order_fk"))
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="specialist", nullable=false , foreignKey = @ForeignKey(name = "specialist_order_fk"))
    private Specialist specialist;


    public Integer getId() {
        return id;
    }

    public CustomerOrder setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public CustomerOrder setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public CustomerOrder setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public CustomerOrder setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public CustomerOrder setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public CustomerOrder setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CustomerOrder setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public CustomerOrder setSpecialist(Specialist specialist) {
        this.specialist = specialist;
        return this;
    }
}
