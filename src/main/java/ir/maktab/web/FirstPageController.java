package ir.maktab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Yeganeh Nobakht
 **/
@Controller

public class FirstPageController {
    @GetMapping(value = "/")
    public String home(){
        return "index";
    }

}
