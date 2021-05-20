package ir.maktab.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    private String price;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "service_category" , nullable = false, foreignKey = @ForeignKey(name = "service_category_fk"))
    private ServiceCategory serviceCategory;

    @OneToMany(orphanRemoval = true , cascade = CascadeType.PERSIST , mappedBy = "serviceCategory" , fetch = FetchType.EAGER)
    private List<CustomerOrder> customerOrderList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public SubCategory setId(Integer id) {
        this.id = id;
        return this;
    }

    public SubCategory(String name, String price, String comment) {
        this.name = name;
        this.price = price;
        this.comment = comment;
    }

    public SubCategory() {
    }

    public String getName() {
        return name;
    }

    public SubCategory setName(String name) {
        this.name = name;
        return this;
    }

    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public SubCategory setServiceCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
        return this;
    }

    public List<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }

    public SubCategory setCustomerOrderList(List<CustomerOrder> customerOrderList) {
        this.customerOrderList = customerOrderList;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public SubCategory setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public SubCategory setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", comment='" + comment + '\'' +
                ", serviceCategory=" + serviceCategory +
                ", customerOrderList=" + customerOrderList +
                '}';
    }
}
