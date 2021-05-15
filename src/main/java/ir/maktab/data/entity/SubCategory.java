package ir.maktab.data.entity;

import javax.persistence.*;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "service_category" , nullable = false, foreignKey = @ForeignKey(name = "service_category_fk"))
    private ServiceCategory serviceCategory;

    public Integer getId() {
        return id;
    }

    public SubCategory setId(Integer id) {
        this.id = id;
        return this;
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
}
