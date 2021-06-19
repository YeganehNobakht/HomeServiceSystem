package ir.maktab.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author Yeganeh Nobakht
 **/
public class PaymentDto {
    @NotBlank(message = "card.number.blank")
    @Pattern(regexp = "[1-9][0-9]{15}",message = "card.number")
    private BigDecimal cardNumber;
    @NotBlank(message = "cvv2.blank")
    @Pattern(regexp = "[0-9]{4}",message = "cvv2")
    private String ccv2;
    @NotBlank(message = "month.blank")
    @Size(min = 1, max = 12, message = "month.size")
    private Integer cardExpirationMonth;
    @NotBlank(message = "year.blank")
    @Size(min = 0, max = 99, message = "year.size")
    private Integer cardExpirationYear;
    @NotBlank(message = "card.pass.blank")
    @Pattern(regexp = "[0-9]{4}",message = "card.pass")
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
