package ir.maktab.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yeganeh Nobakht
 **/
@Controller

public class FirstPageController {
    private final org.apache.log4j.Logger logger = Logger.getLogger(FirstPageController.class);
    public String home() {
        logger.info("...show first page when application is started...");
        return "index";
    }

}
