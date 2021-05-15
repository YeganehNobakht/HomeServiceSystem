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
    @JoinColumn(name="customer_order_fk", nullable=false)
    private Customer customer;
}
