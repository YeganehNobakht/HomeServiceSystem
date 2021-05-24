package ir.maktab.configuration;

import org.springframework.context.annotation.*;

import java.util.Scanner;


@Configuration
@ComponentScan("ir.maktab")
@PropertySource("classpath:database.properties")
@Import(SpringContextDataJPA.class)
public class AppConfiguration {

//    @Bean("scanner")
//    public Scanner scanner(){
//        return new Scanner(System.in);
//    }

}
