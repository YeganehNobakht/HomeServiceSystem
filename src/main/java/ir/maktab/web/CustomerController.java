package ir.maktab.web;

import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.CustomerLoginDto;
import ir.maktab.service.customerService.CustomerService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author Yeganeh Nobakht
 **/
@Controller
@RequestMapping("/customerDto")
@SessionAttributes("customerDto")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /*
     * Add customerDto in model attribute
     */
    @ModelAttribute("customerDto")
    public CustomerDto setUpUserForm() {
        return new CustomerDto();
    }

    @GetMapping(value = {"/login"})
    public ModelAndView showCustomerPage(){
        return new ModelAndView("customerLogin","customerDto",new CustomerDto());
    }
    @PostMapping("/register")
    public String customerLogin
            (@ModelAttribute("CustomerDto") @Valid CustomerDto customerDto,
             BindingResult bindingResult, Model model,
             HttpServletRequest request) throws Exception {
        if (bindingResult.hasErrors()){
            bindingResult.getFieldErrors().forEach(fieldError -> model.addAttribute(fieldError.getField(),fieldError.getDefaultMessage()));
            return "customerLogin";
        }
        CustomerDto customer = customerService.login(customerDto);
        customerDto.setName(customer.getName())
                .setLastName(customer.getLastName())
                .setBalance(customer.getBalance())
                .setCustomerCommentList(customer.getCustomerCommentList())
                .setCustomerOrderList(customer.getCustomerOrderList())
                .setDate(customer.getDate())
                .setEmail(customer.getEmail());
        HttpSession session = request.getSession(true);

        session.setAttribute("myCustomerDto",customer);

        return "customerService";
    }

}
