package ir.maktab.web;

import ir.maktab.data.entity.enums.OrderStatus;
import ir.maktab.data.entity.enums.SuggestionStatus;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.CustomerOrderDto;
import ir.maktab.dto.SuggestionDto;
import ir.maktab.service.customerOrderService.CustomerOrderService;
import ir.maktab.service.customerService.CustomerService;
import ir.maktab.service.suggestionService.SuggestionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yeganeh Nobakht
 **/
@Controller
@RequestMapping("/customer")
@SessionAttributes("customerDto")
public class CustomerController {

    private final Logger logger = Logger.getLogger(CustomerController.class);

    private final CustomerService customerService;
    private final SuggestionService suggestionService;
    private final CustomerOrderService customerOrderService;

    public CustomerController(CustomerService customerService, SuggestionService suggestionService, CustomerOrderService customerOrderService) {
        this.customerService = customerService;
        this.suggestionService = suggestionService;
        this.customerOrderService = customerOrderService;
    }

    /*
     * Add customerDto in model attribute
     */
    @ModelAttribute("customerDto")
    public CustomerDto setUpUserForm() {
        return new CustomerDto();
    }

    @GetMapping(value = {"/login"})
    public ModelAndView showCustomerPage() {
        logger.info("...redirect to customer login page...");
        return new ModelAndView("customerLogin", "customerDto", new CustomerDto());
    }

    @PostMapping("/register")
    public String customerLogin
            (@ModelAttribute("CustomerDto") @Valid CustomerDto customerDto,
             BindingResult bindingResult, Model model,
             HttpServletRequest request) throws Exception {

        logger.info("...redirect to customer register page...");
        if (bindingResult.hasErrors()) {
            logger.error("...error has occurred in customer register page...");
            bindingResult.getFieldErrors().forEach(fieldError -> model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage()));
            return "customerLogin";
        }
        CustomerDto customer = customerService.login(customerDto);
        HttpSession session = request.getSession(true);
        session.setAttribute("myCustomerDto", customer);
        return "customerService";
    }

    @GetMapping("/changePass")
    public String changePass() {
        logger.info("...redirect to customer change password page...");
        return "customerChangePass";
    }

    @PostMapping("/change")
    public ModelAndView change(@RequestParam(value = "old", required = true) String old,
                               @RequestParam(value = "new", required = true) String newPass,
                               @SessionAttribute("myCustomerDto") CustomerDto customerDto) throws Exception {

        logger.info("...changing customer password process...");
        Map<String, String> message = new HashMap<>();
        if (customerDto.getPassword().equals(old)) {
            customerDto.setPassword(newPass);
            customerService.update(customerDto);
            message.put("message", "Password successfully changed");
        } else{
            message.put("message", "Old password is incorrect");
            logger.warn("...old pass does not match...");
        }
        return new ModelAndView("customerChangePass", message);
    }

    @GetMapping("showOrders")
    public String ShowOrders() throws Exception {

        logger.info("...redirect to customer show orders page...");
            return "customerShowOrders";
    }

    @GetMapping("/currentOrder")
    public String currentOrder(@SessionAttribute("myCustomerDto") CustomerDto customerDto, Model model) throws Exception {

        logger.info("...redirect to customer current order page...");
        List<CustomerOrderDto> orders = customerOrderService.findByOrderStatusNotAndCustomer_Id(OrderStatus.PAID,customerDto.getId());
        model.addAttribute("orders", orders);
        return "customerCurrentOrder";
    }

    @GetMapping("/getSuggestion/{orderId}")
    public String findOrder(@PathVariable(value = "orderId") Integer orderId,
                            Model model, HttpServletRequest request) throws Exception {

        logger.info("...show all suggestions that related to an order...");
        CustomerOrderDto orderDto = customerOrderService.findById(orderId);
        if (orderDto.getOrderStatus().equals(OrderStatus.WAITING_FOR_SPECIALIST_OFFER)) {
            logger.info("...find all order with WAITING_FOR_SPECIALIST_OFFER status...");
            List<SuggestionDto> suggestions = suggestionService.findByCustomerOrder(orderDto);
            model.addAttribute("suggestions", suggestions);

            HttpSession session = request.getSession(true);
            session.setAttribute("orderDto", orderDto);

            model.addAttribute("suggestion", new SuggestionDto());

            //TODO:: return error: "id is wrong" to specialistShowOrder
            return "customerOrderSuggestion";
        }
        if (orderDto.getOrderStatus().equals(OrderStatus.WAITING_FOR_SPECIALIST_CHOSE)) {
            logger.info("...order with WAITING_FOR_SPECIALIST_CHOSE status...");
            model.addAttribute("message", "Your order is waiting for expert approval.");
            return "customerCurrentOrder";
        }
        if (orderDto.getOrderStatus().equals(OrderStatus.WAITING_FOR_SPECIALIST_COME)) {
            logger.info("...order with WAITING_FOR_SPECIALIST_COME status...");
            model.addAttribute("message", "Your order is waiting for a specialist to arrive.");
            return "customerCurrentOrder";
        }
        if (orderDto.getOrderStatus().equals(OrderStatus.STARTED)) {
            logger.info("... order with STARTED status...");
            model.addAttribute("message", "Your order is in progress.");
            return "customerCurrentOrder";
        }
        if (orderDto.getOrderStatus().equals(OrderStatus.FINISHED_WORK)) {
            logger.info("...order with FINISHED_WORK status...");
            model.addAttribute("message", "Your order is finished, now you can pay it.");
            return "customerCurrentOrder";
        }
        if (orderDto.getOrderStatus().equals(OrderStatus.WAIT_FOR_PAID)) {
            logger.info("...order with WAIT_FOR_PAID status...");
            return "customerPaymentInformations";
        }
        return "customerCurrentOrder";
    }

    @GetMapping("/selectASuggestion/{suggestionId}")
    public String getSuggestion(@PathVariable(value = "suggestionId") Integer id,
                                Model model, HttpServletRequest request,
                                @SessionAttribute("orderDto") CustomerOrderDto orderDto) throws Exception {

        logger.info("...set a suggestion for an order...");
        SuggestionDto suggestionDto = suggestionService.findById(id);
        suggestionDto.setSuggestionStatus(SuggestionStatus.ACCEPTED);
        SuggestionDto suggestionDto1 = suggestionService.update(suggestionDto);
        orderDto.setAcceptedSuggestionDto(suggestionDto).setSpecialistDto(suggestionDto.getSpecialistDto());
        List<SuggestionDto> allSuggestion = suggestionService.findByCustomerOrder(orderDto);
//        allSuggestion.remove(suggestionDto1);
//        allSuggestion.forEach(s->suggestionService.update(s.setSuggestionStatus(SuggestionStatus.REJECTED)));
        for (SuggestionDto s: allSuggestion){
            if (!s.getId().equals(suggestionDto.getId())){
                suggestionService.update(s.setSuggestionStatus(SuggestionStatus.REJECTED));
            }
        }
        orderDto.setOrderStatus(OrderStatus.WAITING_FOR_SPECIALIST_CHOSE).setPrice(suggestionDto.getPrice());
        customerOrderService.updateOrderStatus(orderDto);
        model.addAttribute("success", "Suggestion successfully registered.");
        return "success";

    }
    @GetMapping("/finishOrder")
    public String finishOrder(@SessionAttribute("myCustomerDto")CustomerDto customerDto,
            Model model) throws Exception {
        logger.info("...show finishing orders...");
        List<CustomerOrderDto> customerOrderDto = customerOrderService.findUserByStatusAndCustomer(OrderStatus.WAIT_FOR_PAID, customerDto);
        if (customerOrderDto.size()!=0){
            model.addAttribute("order",customerOrderDto);
        }
        else {
            logger.warn("...there is not any finished order...");
            model.addAttribute("message","There is no finished order");
        }

        return "customerOrderForPay";
    }
    @GetMapping("/paymentInformations/{orderId}")
    public String getPaymentInformations(@PathVariable(value = "orderId") Integer id,
                                         Model model,HttpServletRequest request) throws Exception {
        logger.info("...show payment information for customer...");
        CustomerOrderDto customerOrderDto = customerOrderService.findById(id);
        model.addAttribute("customerOrderDto",customerOrderDto);
        HttpSession session = request.getSession(true);
        session.setAttribute("price",customerOrderDto.getPrice());
        session.setAttribute("customerOrderDto",customerOrderDto);
        return "customerPaymentInformations";
    }

    @GetMapping("/completeOrder")
    public String showCompleteOrder(@SessionAttribute("myCustomerDto") CustomerDto customerDto, Model model) throws Exception {
        logger.info("...show completed order...");
        //TODO:: handel Exception fo this method if not order exist
        List<CustomerOrderDto> orderDto = customerOrderService.findUserByStatusAndCustomer(OrderStatus.PAID, customerDto);
        model.addAttribute("orderDto",orderDto);
        return "customerCompletedOrder";
    }
}
