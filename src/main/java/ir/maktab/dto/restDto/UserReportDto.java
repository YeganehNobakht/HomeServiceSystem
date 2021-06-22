package ir.maktab.dto.restDto;

import java.util.Date;

public class UserReportDto {
    private Integer maxNumSuggestion;
    private Integer minNumSuggestion;
    private Integer maxNumOrders;
    private Integer minNumOrders;
    private Date startDate;
    private Date endDate;

    public Integer getMaxNumSuggestion() {
        return maxNumSuggestion;
    }

    public UserReportDto setMaxNumSuggestion(Integer maxNumSuggestion) {
        this.maxNumSuggestion = maxNumSuggestion;
        return this;
    }

    public Integer getMinNumSuggestion() {
        return minNumSuggestion;
    }

    public UserReportDto setMinNumSuggestion(Integer minNumSuggestion) {
        this.minNumSuggestion = minNumSuggestion;
        return this;
    }

    public Integer getMaxNumOrders() {
        return maxNumOrders;
    }

    public UserReportDto setMaxNumOrders(Integer maxNumOrders) {
        this.maxNumOrders = maxNumOrders;
        return this;
    }

    public Integer getMinNumOrders() {
        return minNumOrders;
    }

    public UserReportDto setMinNumOrders(Integer minNumOrders) {
        this.minNumOrders = minNumOrders;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public UserReportDto setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public UserReportDto setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}