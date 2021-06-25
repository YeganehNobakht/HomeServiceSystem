package ir.maktab.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Scanner;


@Configuration
@ComponentScan("ir.maktab")
@PropertySource("classpath:database.properties")
@Import(SpringContextDataJPA.class)
@EnableWebMvc
public class AppConfiguration {

    @Bean("messageSource")
    public MessageSource getMessageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean("scanner")
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        //set max upload size per file is 300KB
        commonsMultipartResolver.setMaxUploadSizePerFile(300 * 1024);
        return commonsMultipartResolver;
    }

}
