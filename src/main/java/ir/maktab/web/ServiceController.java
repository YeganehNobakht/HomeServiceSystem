package ir.maktab.web;

import ir.maktab.dto.ServiceCategoryDto;
import ir.maktab.dto.SubCategoryDto;
import ir.maktab.service.serviceCategory.ServiceCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service")
public class ServiceController {
    private final ServiceCategoryService serviceCategoryService;

    public ServiceController(ServiceCategoryService serviceCategoryService) {
        this.serviceCategoryService = serviceCategoryService;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("subServiceDto") ServiceCategoryDto serviceCategoryDto, Model model) throws Exception {
        ServiceCategoryDto service = serviceCategoryService.getByName(serviceCategoryDto.getName());
        if (service!=null) {
            serviceCategoryService.sava(serviceCategoryDto);
            model.addAttribute("success", "Service successfully added.");
        }
        else
            model.addAttribute("success", "Service already exist.");
        return "success";
    }
}
