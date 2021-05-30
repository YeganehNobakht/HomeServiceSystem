package ir.maktab.dto;

public class SuggestionDto {

    private Long id;

    private Double price;

    private String workDescription;

    private String durationOfWork;

    private String startTime;

    private CustomerOrderDto customerOrder;

    private SpecialistDto specialistDto;


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

    public CustomerOrderDto getCustomerOrder() {
        return customerOrder;
    }

    public SuggestionDto setCustomerOrder(CustomerOrderDto customerOrder) {
        this.customerOrder = customerOrder;
        return this;
    }

    public SpecialistDto getSpecialistDto() {
        return specialistDto;
    }

    public SuggestionDto setSpecialistDto(SpecialistDto specialistDto) {
        this.specialistDto = specialistDto;
        return this;
    }
}
