package ir.maktab.configuration;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.data.entity.Manager;
import ir.maktab.data.entity.Specialist;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
import java.util.Scanner;

public class HibernateConfiguration {


    @Bean("sessionFactory")
    public SessionFactory getSessionFactory(){
        try {
            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
            configuration.addAnnotatedClass(Manager.class);
            configuration.addAnnotatedClass(Specialist.class);
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(CustomerOrder.class);
            configuration.setProperties(new Properties(){
                {
                    put("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
                    put("hibernate.connection.url","jdbc:mysql://localhost:3306/home_service");
                    put("hibernate.connection.username","root");
                    put("hibernate.connection.password","root");
                    put("hibernate.hbm2ddl.auto","update");
                    put("hibernate.show_sql","true");
                }

            });

            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

