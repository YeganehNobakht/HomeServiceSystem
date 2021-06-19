package ir.maktab.web;

import ir.maktab.dto.*;
import ir.maktab.dto.enums.UserRole;
import ir.maktab.service.managerService.ManagerService;
import ir.maktab.service.serviceCategory.ServiceCategoryService;
import ir.maktab.service.userService.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/mngr")
public class managerController {
    private final Logger logger = Logger.getLogger(managerController.class);
    private final ManagerService managerService;
    private final UserService userService;
    private final ServiceCategoryService serviceCategoryService;

    public managerController(ManagerService managerService, UserService userService, ServiceCategoryService serviceCategoryService) {
        this.managerService = managerService;
        this.userService = userService;
        this.serviceCategoryService = serviceCategoryService;
    }

    @GetMapping("/login")
    public ModelAndView showManagerPage() {
        logger.info("...manager login...");
        return new ModelAndView("managerLogin", "managerDto", new ManagerDto());
    }

    @PostMapping("/register")
    public String managerLogin
            (@ModelAttribute("managerDto") @Valid ManagerDto managerDto,
             BindingResult bindingResult, Model model,
             HttpServletRequest request) throws Exception {
        logger.info("...manager register...");
        if (bindingResult.hasErrors()) {
            logger.error("...error occurred...");
            bindingResult.getFieldErrors().forEach(fieldError -> model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage()));
            return "customerLogin";
        }
        ManagerDto myManagerDto = managerService.login(managerDto);
        HttpSession session = request.getSession(true);
        session.setAttribute("myManagerDto", myManagerDto);
        return "managerService";
    }

//    @GetMapping("/addService")
//    public

    @GetMapping("/userInfo")
    public ModelAndView getUsers(Model model,HttpServletRequest request){
        logger.info("...show user informations...");
        List<UserDto> allUser = userService.findAll();
        model.addAttribute("allUser",allUser);
        List<ServiceCategoryDto> all = serviceCategoryService.getAll();
//        model.addAttribute("serviceList",all);
        HttpSession session = request.getSession();
        session.setAttribute("services",all);
        session.setAttribute("role",new UserRole[]{UserRole.Customer, UserRole.Specialist});
//        model.addAttribute("role", new UserRole[]{UserRole.Customer, UserRole.Specialist});
        return new ModelAndView("managerGetUserInfo","userDto",new UserFilter());
    }

    @PostMapping("/search")
    public ModelAndView searchSuggestions(@ModelAttribute("userDto") UserFilter userFilter) throws Exception {
        logger.info("...filter for user information...");
        return new ModelAndView("managerGetUserInfo","allUser",userService.filterUser(userFilter));
    }

    @GetMapping("/addService")
    public ModelAndView addService(){
        logger.info("...adding service...");
        return new ModelAndView("managerAddService","serviceDto",new ServiceCategoryDto());
    }

    @GetMapping("/subService")
    public ModelAndView addSubService(Model model){
        logger.info("...adding sub-service...");
        List<ServiceCategoryDto> all = serviceCategoryService.getAll();
        model.addAttribute("serviceList",all);
        return new ModelAndView("managerAddSubService","subServiceDto",new SubCategoryDto());
    }
}
