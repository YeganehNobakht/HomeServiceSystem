package ir.maktab.dto;

import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.data.entity.Specialist;

public class SuggestionDto {

    private Long id;

    private Double price;

    private String workDescription;

    private String durationOfWork;

    private String startTime;

    private CustomerOrder customerOrder;

    private Specialist specialist;

    public Long getId() {
        return id;
    }

    public SuggestionDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public SuggestionDto setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public SuggestionDto setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
        return this;
    }

    public String getDurationOfWork() {
        return durationOfWork;
    }

    public SuggestionDto setDurationOfWork(String durationOfWork) {
        this.durationOfWork = durationOfWork;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public SuggestionDto setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public SuggestionDto setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
        return this;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public SuggestionDto setSpecialist(Specialist specialist) {
        this.specialist = specialist;
        return this;
    }
}
