package ir.maktab.web;

import ir.maktab.dto.*;
import ir.maktab.service.customerOrderService.CustomerOrderService;
import ir.maktab.service.serviceCategory.ServiceCategoryService;
import ir.maktab.service.subCategoryService.SubCategoryService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yeganeh Nobakht
 **/

@Controller
@RequestMapping("/order")
@SessionAttributes("newOrder")
public class OrderController {

    private final ServiceCategoryService categoryService;
    private final CustomerOrderService customerOrderService;
    private final SubCategoryService subCategoryService;

    public OrderController(ServiceCategoryService categoryService, CustomerOrderService customerOrderService, SubCategoryService subCategoryService) {
        this.categoryService = categoryService;
        this.customerOrderService = customerOrderService;
        this.subCategoryService = subCategoryService;
    }

//    @GetMapping("/showOrder")
//    public ModelAndView showOrder(){
//        List<ServiceCategoryDto> all = categoryService.getAll();
//        Map<String, Object> model = new HashMap<>();
//        for (ServiceCategoryDto service:all){
//            model.put(service.getName(),service.getSubCategoryList());
//        }
//
//        model.put("services",all);
//        return new ModelAndView("showOrder",model);
//
//    }

    @GetMapping("/show")
    public String createOrder(@SessionAttribute("myCustomerDto")CustomerDto customerDto, Model model, HttpServletRequest request) throws Exception {

        if (customerOrderService.findByCustomer(customerDto).size() == 0) {
            List<ServiceCategoryDto> all = categoryService.getAll();

            model.addAttribute("newOrder", new OrderDto());
            model.addAttribute("serviceList", all);
            model.addAttribute("selectedService", "select");
            HttpSession session = request.getSession();
            session.setAttribute("serviceList", all);
            session.setAttribute("newOrder", model.getAttribute("newOrder"));
            return "showOrder";
        }
        else {
            model.addAttribute("success", "You already have an active order");
            return "success";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @PostMapping("/add")
    public ModelAndView addOrder(@ModelAttribute("newOrder")
                                     @Valid OrderDto orderDto,
//            @RequestParam(value = "service", required = true) String service,
//            @RequestParam(value = "subCategory", required = true) String subCategory,
//            @RequestParam(value = "jobDescription", required = false) String jobDescription,
//            @RequestParam(value = "workDate", required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") Date workDate,
//            @RequestParam(value = "city", required = false) String city,
//            @RequestParam(value = "street", required = false) String street,
//            @RequestParam(value = "alley", required = false) String alley,
            @SessionAttribute("myCustomerDto") CustomerDto customerDto,
            HttpServletRequest request) throws Exception {

        orderDto.setCustomerDto(customerDto);
        customerOrderService.addOrder(orderDto);
        Map<String, String> successMsg = new HashMap<>();
        successMsg.put("success", "Order Successfully Added.");
        return new ModelAndView("success", successMsg);
    }


}
