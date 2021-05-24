package ir.maktab.web;

import ir.maktab.service.applicationService.ApplicationService;
import org.springframework.stereotype.Controller;

@Controller
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    public void runApplication() throws Exception {
        applicationService.runApplication();
    }
}
