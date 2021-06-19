package ir.maktab.web;

import ir.maktab.data.entity.enums.OrderStatus;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.CustomerOrderDto;
import ir.maktab.dto.PaymentDto;
import ir.maktab.service.customerOrderService.CustomerOrderService;
import ir.maktab.service.customerService.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Yeganeh Nobakht
 **/
@Controller
@RequestMapping("/payment")
public class PaymentController {
    private final Logger logger = Logger.getLogger(PaymentController.class);
    private final CustomerOrderService customerOrderService;
    private final CustomerService customerService;

    public PaymentController(CustomerOrderService customerOrderService, CustomerService customerService) {
        this.customerOrderService = customerOrderService;
        this.customerService = customerService;
    }

    @GetMapping("/byCard")
    public ModelAndView payByCard(Model model){
        logger.info("...payment by card...");
        return new ModelAndView("payment","paymentDto",new PaymentDto());
    }

    @GetMapping("/byBalance")
    public String payByAccount(@SessionAttribute("myCustomerDto") CustomerDto customerDto,
                               @SessionAttribute("price") double price,Model model){
        logger.info("...payment by account balance...");
        if (customerDto.getBalance()<price){
            logger.warn("...low balance...");
            model.addAttribute("message","Your account balance is too low.");
            return "customerPaymentInformations";
        }
        customerService.payByAccount(customerDto,price);
        model.addAttribute("success","Tanks for your payment.");
        return ("success");
    }

  @PostMapping("/complete")
  public String save(@ModelAttribute("paymentDto") PaymentDto paymentDto,
                     @SessionAttribute("price")double price,
                     @SessionAttribute("myCustomerDto") CustomerDto customerDto,
                     HttpSession session, HttpServletRequest request,
                       Model model) throws Exception {
      logger.info("...complete payment transaction...");
        String captcha = session.getAttribute("captcha_security").toString();
        String verifyCaptcha = request.getParameter("captcha");
        if (captcha.equals(verifyCaptcha)) {
            model.addAttribute("success", "Your transaction successfully completed.");
            CustomerOrderDto customerOrderDto = (CustomerOrderDto) session.getAttribute("customerOrderDto");
            customerOrderService.updateOrderStatus(customerOrderDto.setOrderStatus(OrderStatus.PAID));

            double money = customerService.returnMoney(price,customerDto);
            model.addAttribute("money","Thank you for your support, the amount of "+money+"T was returned to your account.");
            return "success";
        } else {
            model.addAttribute("error", "Captcha Invalid");
            return "payment";
        }

    }

    @GetMapping("/timeout")
    public String redirect(){
        logger.warn("...payment timeout...");
        return "timeOut";
    }
}
