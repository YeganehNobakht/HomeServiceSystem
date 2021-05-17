package ir.maktab.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Scanner;

@Configuration
@ComponentScan("ir.maktab")
@Import(HibernateConfiguration.class)
public class AppConfiguration {

    @Bean("scanner")
    public Scanner scanner(){
        return new Scanner(System.in);
    }

}
