package ir.maktab.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Yeganeh Nobakht
 **/
public class PaymentDto {
    private BigDecimal cardNumber;
    private String ccv2;
    private Integer cardExpirationMonth;
    private Integer cardExpirationYear;
    private Integer dynamicPassword;
    private String email;
    private String captcha;
    private double price;

    public String getCaptcha() {
        return captcha;
    }

    public PaymentDto setCaptcha(String captcha) {
        this.captcha = captcha;
        return this;
    }

    public BigDecimal getCardNumber() {
        return cardNumber;
    }

    public PaymentDto setCardNumber(BigDecimal cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getCcv2() {
        return ccv2;
    }

    public PaymentDto setCcv2(String ccv2) {
        this.ccv2 = ccv2;
        return this;
    }

    public Integer getCardExpirationMonth() {
        return cardExpirationMonth;
    }

    public PaymentDto setCardExpirationMonth(Integer cardExpirationMonth) {
        this.cardExpirationMonth = cardExpirationMonth;
        return this;
    }

    public Integer getCardExpirationYear() {
        return cardExpirationYear;
    }

    public PaymentDto setCardExpirationYear(Integer cardExpirationYear) {
        this.cardExpirationYear = cardExpirationYear;
        return this;
    }

    public Integer getDynamicPassword() {
        return dynamicPassword;
    }

    public PaymentDto setDynamicPassword(Integer dynamicPassword) {
        this.dynamicPassword = dynamicPassword;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PaymentDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public PaymentDto setPrice(double price) {
        this.price = price;
        return this;
    }
}
