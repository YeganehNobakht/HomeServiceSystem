package ir.maktab.dto.restDto;

import ir.maktab.data.entity.enums.OrderStatus;

import java.util.Date;

public class OrderFilterDto {
    private String serviceName;
    private String subServiceName;
    private OrderStatus orderStatus;
    private Date startDate;
    private Date endDate;

    public String getServiceName() {
        return serviceName;
    }

    public OrderFilterDto setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public String getSubServiceName() {
        return subServiceName;
    }

    public OrderFilterDto setSubServiceName(String subServiceName) {
        this.subServiceName = subServiceName;
        return this;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public OrderFilterDto setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public OrderFilterDto setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public OrderFilterDto setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
