package ir.maktab.web;

import ir.maktab.service.applicationService.ApplicationService;

public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    public void runApplication() throws Exception {
        applicationService.runApplication();
    }
}
