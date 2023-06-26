package com.skypro.spring;

import com.skypro.spring.transports.Bus;
import com.skypro.spring.transports.Car;
import com.skypro.spring.transports.Pickup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@ComponentScan
@Configuration
public class HomeworkApplication {
    @Autowired
    @Qualifier("BMW_X5")
    private Car car;

    @Autowired
    @Qualifier("Iveco")
    private Pickup pickup;

    @Autowired
    @Qualifier("Scania")
    private Bus bus;

    @Autowired
    @Qualifier("Driver_Michael")
    private Driver<Car> driverB;

    @Autowired
    @Qualifier("Driver_Ivan")
    private Driver<Pickup> driverC;
    @Autowired
    @Qualifier("Driver_Alex")
    private Driver<Bus> driverD;

    @PostConstruct
    public void printDrivers() {
        System.out.println(car + " готов к работе");
        System.out.println(pickup + " готов к работе");
        System.out.println(bus + " готов к работе");

        System.out.println(driverB);
        System.out.println(driverC);
        System.out.println(driverD);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class, HomeworkApplication.class);
    }

}
