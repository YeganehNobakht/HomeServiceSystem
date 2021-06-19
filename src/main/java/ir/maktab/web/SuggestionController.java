package ir.maktab.web;

import ir.maktab.data.entity.enums.SuggestionStatus;
import ir.maktab.dto.CustomerOrderDto;
import ir.maktab.dto.SpecialistDto;
import ir.maktab.dto.SuggestionDto;
import ir.maktab.service.customerOrderService.CustomerOrderService;
import ir.maktab.service.suggestionService.SuggestionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/suggestion")
public class SuggestionController {
    private final Logger logger = Logger.getLogger(SuggestionController.class);
    private final SuggestionService suggestionService;
    private final CustomerOrderService orderService;

    public SuggestionController(SuggestionService suggestionService, CustomerOrderService orderService) {
        this.suggestionService = suggestionService;
        this.orderService = orderService;
    }

    @GetMapping("/getSuggestion/{orderId}")
    public ModelAndView findOrder(@SessionAttribute("mySpecialistDto")SpecialistDto specialistDto,
            @PathVariable(value = "orderId") Integer orderId, HttpServletRequest request) {
        logger.info("...put suggestion for an order...");
        HttpSession session = request.getSession(true);
        session.setAttribute("orderId",orderId);
        SuggestionDto suggestionDto = suggestionService.findBySpecialist_IdAndOrderId(specialistDto.getId(), orderId);
        if (suggestionDto==null) {
            //TODO:: return error: "id is wrong" to specialistShowOrder
            return new ModelAndView("specialistSuggestion", "suggestionDto", new SuggestionDto());
        }
        else {
            logger.warn("...order already has suggestion...");
            Map<String,String> alarm = new HashMap<>();
            alarm.put("alarm","You already put a suggestion for this order.");
            return new ModelAndView("specialistShowOrder","alarm",alarm);
        }
    }

    @PostMapping("/add")
    public ModelAndView addSuggestion(@SessionAttribute("mySpecialistDto") SpecialistDto specialistDto,
            @ModelAttribute("suggestionDto")@Valid SuggestionDto suggestionDto,
            @SessionAttribute("orderId")Integer id) throws Exception {
        logger.info("...create a suggestion...");
        CustomerOrderDto orderDto = orderService.findById(id);
        suggestionDto.setSpecialistDto(specialistDto).setCustomerOrder(orderDto).setSuggestionStatus(SuggestionStatus.REGISTERED);

        suggestionService.addSuggestionForOrder(suggestionDto);
        Map<String, String> successMsg = new HashMap<>();
        successMsg.put("success", "Suggestion Successfully Added.");
        return new ModelAndView("success", successMsg);
    }

    @PostMapping("/search")
    public ModelAndView searchSuggestions(@ModelAttribute("suggestion") SuggestionDto suggestionDto,
                                          @SessionAttribute("orderDto")CustomerOrderDto customerOrderDto){
        logger.info("...filtering suggestions...");
        suggestionDto.setCustomerOrder(customerOrderDto);
        return new ModelAndView("customerOrderSuggestion","suggestions",suggestionService.filterSuggestion(suggestionDto));
    }

}
