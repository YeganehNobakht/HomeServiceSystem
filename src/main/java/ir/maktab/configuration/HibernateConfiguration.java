package ir.maktab.configuration;

import ir.maktab.data.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;

@Configuration
@PropertySource("classpath:database.properties")
public class HibernateConfiguration {

    private final Environment environment;

    public HibernateConfiguration(Environment environment) {
        this.environment = environment;
    }


    @Bean("sessionFactory")
    public SessionFactory getSessionFactory() {
        try {
            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
            configuration.addAnnotatedClass(Manager.class);
            configuration.addAnnotatedClass(Specialist.class);
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(CustomerOrder.class);
            configuration.addAnnotatedClass(ServiceCategory.class);
            configuration.addAnnotatedClass(SubCategory.class);
            configuration.addAnnotatedClass(CustomerComment.class);
            configuration.setProperties(new Properties() {
                {
                    put("hibernate.connection.driver_class", environment.getRequiredProperty("hibernate.connection.driver_class"));
                    put("hibernate.connection.url", environment.getRequiredProperty("hibernate.connection.url"));
                    put("hibernate.connection.username", environment.getRequiredProperty("hibernate.connection.username"));
                    put("hibernate.connection.password", environment.getRequiredProperty("hibernate.connection.password"));
                    put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
                    put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
                    put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
                    put("hibernate.connection.isolation", environment.getRequiredProperty("hibernate.connection.isolation"));
                }

            });

            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

