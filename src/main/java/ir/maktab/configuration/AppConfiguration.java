package ir.maktab.configuration;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Scanner;


@Configuration
@ComponentScan("ir.maktab")
@PropertySource("classpath:database.properties")
@Import(SpringContextDataJPA.class)
@EnableWebMvc
public class AppConfiguration {

    @Bean("scanner")
    public Scanner scanner() {
        return new Scanner(System.in);
    }

}
