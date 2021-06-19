package ir.maktab.web;

import ir.maktab.data.entity.enums.OrderStatus;
import ir.maktab.data.entity.enums.SuggestionStatus;
import ir.maktab.dto.*;
import ir.maktab.service.customerOrderService.CustomerOrderService;
import ir.maktab.service.serviceCategory.ServiceCategoryService;
import ir.maktab.service.specialistService.SpecialistService;
import ir.maktab.service.suggestionService.SuggestionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Yeganeh Nobakht
 **/
@Controller
@RequestMapping("/specialist")
public class SpecialistController {
    private final Logger logger = Logger.getLogger(SpecialistController.class);
    private final SpecialistService specialistService;
    private final CustomerOrderService customerOrderService;
    private final ServiceCategoryService serviceCategoryService;
    private final SuggestionService suggestionService;

    public SpecialistController(SpecialistService specialistService, CustomerOrderService customerOrderService, ServiceCategoryService serviceCategoryService, SuggestionService suggestionService) {
        this.specialistService = specialistService;
        this.customerOrderService = customerOrderService;
        this.serviceCategoryService = serviceCategoryService;
        this.suggestionService = suggestionService;
    }
    @GetMapping("/login")
    public ModelAndView login(){
        logger.info("...specialist login page...");
        return new ModelAndView("specialistLogin","specialistDto", new SpecialistDto());
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("specialistDto") SpecialistDto specialistDto,
                           BindingResult bindingResult, Model model,
                           HttpServletRequest request) throws Exception {
        logger.info("...specialist registered...");
        if (bindingResult.hasErrors())
            return "specialistLogin";

            SpecialistDto login = specialistService.login(specialistDto);
            HttpSession session = request.getSession(true);
            session.setAttribute("mySpecialistDto", login);

        return "specialistService";
    }

    @GetMapping("/signUp")
    public ModelAndView signUp(HttpServletRequest request){
        logger.info("...specialist sign up page...");
        HttpSession session = request.getSession(true);
        List<ServiceCategoryDto> allServices = serviceCategoryService.getAll();
        session.setAttribute("allServices",allServices);
        return new ModelAndView("specialistSignUp","specialistDto",new SpecialistSignUpDto());
    }

    @PostMapping("/registerSignUp")
    public String registerSignUp(@ModelAttribute("specialistDto")SpecialistSignUpDto specialistDto,
                                 BindingResult bindingResult,
                                 HttpServletRequest request) throws Exception {
        logger.info("...specialist register from sign up page...");
        if (bindingResult.hasErrors())
            return "specialistSignUp";
        HttpSession session = request.getSession(true);
        if (session.getAttribute("mySpecialistDto")==null) {
            ServiceCategoryDto service = serviceCategoryService.getByName(specialistDto.getServiceCategory().getName());
            specialistDto.setServiceCategory(service);
            SpecialistDto specialistDto1 = specialistService.create(specialistDto);
            session.setAttribute("mySpecialistDto", specialistDto1);
        }
        return "specialistService";
    }

    @GetMapping("/showOrder")
    public ModelAndView showOrder( @SessionAttribute("mySpecialistDto") SpecialistDto specialistDto ) throws Exception {
        logger.info("...show all unselected order for specialist...");
        List<ServiceCategoryDto> serviceCategoryDtoList = specialistDto.getServiceCategoryList();
        Set<CustomerOrderDto> orderDtoList = new HashSet<>();
        Map<String , Object>  orderMap = new HashMap<>();
        for (ServiceCategoryDto s: serviceCategoryDtoList){
            List<CustomerOrderDto> order = customerOrderService.findByService(s);
            for (CustomerOrderDto o:order) {
                if (suggestionService.findBySpecialist_IdAndOrderId(specialistDto.getId(), o.getId()) == null)
                    orderDtoList.add(o);
            }
        }
        orderMap.put("order",orderDtoList);
        return new ModelAndView("specialistShowOrder",orderMap);

    }
    @GetMapping("/changePass")
    public String changePass(){
        return "specialistChangePass";
    }
    @PostMapping("/change")
    public ModelAndView change(@RequestParam(value = "old", required = true) String old,
                               @RequestParam(value = "new", required = true) String newPass,
                                @SessionAttribute("mySpecialistDto") SpecialistDto specialistDto) throws Exception {
        logger.info("...specialist change password...");
        Map<String , String > message = new HashMap<>();
        if (specialistDto.getPassword().equals(old)){
            specialistDto.setPassword(newPass);
            specialistService.update(specialistDto);
            message.put("message","Password successfully changed");
        }
        else
            logger.warn("...old pass does not match...");
            message.put("message","Old password is incorrect");

        return new ModelAndView("specialistChangePass",message);
    }

    @GetMapping("/showAllOrders")
    public String showAllOrders(){
        logger.info("...current and completed orders...");
        return "specialistShowAllOrders";
    }

    @GetMapping("/currentOrder")
    public String currentOrder(@SessionAttribute("mySpecialistDto")SpecialistDto specialistDto,
                               HttpServletRequest request,Model model) throws Exception {
        logger.info("...current orders...");
        List<SuggestionDto> suggestionDtoList = suggestionService.findUserBySuggestionStatusAndSpecialist(SuggestionStatus.ACCEPTED, specialistDto.getId());
        HttpSession session = request.getSession(true);
        session.setAttribute("suggestionList",suggestionDtoList);

        List<CustomerOrderDto> orderDtoList = suggestionDtoList.stream().map(SuggestionDto::getCustomerOrder).collect(Collectors.toList());
        model.addAttribute("orders", orderDtoList);
        return "specialistCurrentOrder";
    }

    @GetMapping("/changeStatus/{orderId}")
    public String findOrder(@PathVariable(value = "orderId") Integer orderId,
                            @SessionAttribute("suggestionList")List<SuggestionDto> suggestionDtoList,
                            Model model, HttpServletRequest request) throws Exception {
        logger.info("...change status of an order which selected...");
        List<SuggestionDto> suggestionDto = suggestionDtoList.stream().filter(s -> s.getCustomerOrder().getId().equals(orderId)).collect(Collectors.toList());
        if (suggestionDto.get(0).getCustomerOrder().getOrderStatus().equals(OrderStatus.WAITING_FOR_SPECIALIST_CHOSE)) {
            customerOrderService.updateOrderStatus(suggestionDto.get(0).getCustomerOrder().setOrderStatus(OrderStatus.WAITING_FOR_SPECIALIST_COME));
            model.addAttribute("success", "Order Successfully accepted.");
            return "success";
        }
        if (suggestionDto.get(0).getCustomerOrder().getOrderStatus().equals(OrderStatus.WAITING_FOR_SPECIALIST_COME)) {
            customerOrderService.updateOrderStatus(suggestionDto.get(0).getCustomerOrder().setOrderStatus(OrderStatus.STARTED));
            model.addAttribute("success", "Change status to WAITING_FOR_SPECIALIST_COME.");
            return "success";
        }
        if (suggestionDto.get(0).getCustomerOrder().getOrderStatus().equals(OrderStatus.STARTED)) {
            customerOrderService.updateOrderStatus(suggestionDto.get(0).getCustomerOrder().setOrderStatus(OrderStatus.FINISHED_WORK));
            model.addAttribute("success", "Change status to STARTED.");
            return "success";
        }
        if (suggestionDto.get(0).getCustomerOrder().getOrderStatus().equals(OrderStatus.FINISHED_WORK)) {
            customerOrderService.updateOrderStatus(suggestionDto.get(0).getCustomerOrder().setOrderStatus(OrderStatus.WAIT_FOR_PAID));
            model.addAttribute("success", "Order is finished and now waiting for pay.");
            return "success";
        }
        if (suggestionDto.get(0).getCustomerOrder().getOrderStatus().equals(OrderStatus.WAIT_FOR_PAID)) {
            model.addAttribute("success", "This order is waiting for pay.");
            return "success";
        }
        return "specialistCurrentOrder";
    }

    @GetMapping("/completeOrder")
    public String showCompleteOrder(@SessionAttribute("mySpecialistDto") SpecialistDto specialistDto,Model model){
        logger.info("...chane status of completed orders...");
        List<SuggestionDto> suggestionDtos = suggestionService.findUserBySuggestionStatusAndSpecialist(SuggestionStatus.DONE, specialistDto.getId());
        List<CustomerOrderDto> orderDto = suggestionDtos.stream().map(SuggestionDto::getCustomerOrder).collect(Collectors.toList());
        model.addAttribute("orderDto",orderDto);
        return "specialistCompletedOrder";
    }
}
