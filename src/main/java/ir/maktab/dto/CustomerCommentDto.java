package ir.maktab.dto;

public class CustomerCommentDto {
    private Integer id;

    private String comment;

    private Double score;

    private CustomerDto customerDto;

    private SpecialistDto specialistDto;

    public Integer getId() {
        return id;
    }

    public CustomerCommentDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public CustomerCommentDto setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public CustomerCommentDto setScore(Double score) {
        this.score = score;
        return this;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public CustomerCommentDto setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
        return this;
    }

    public SpecialistDto getSpecialistDto() {
        return specialistDto;
    }

    public CustomerCommentDto setSpecialistDto(SpecialistDto specialistDto) {
        this.specialistDto = specialistDto;
        return this;
    }
}
