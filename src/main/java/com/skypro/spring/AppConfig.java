package com.skypro.spring;

import com.skypro.spring.transports.Bus;
import com.skypro.spring.transports.Car;
import com.skypro.spring.transports.Pickup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "BMW_X5")
    public Car getCarBean() {
        return new Car("BMW", "X5", 5.0, Car.BodyType.CROSSOVER);
    }

    @Bean(name = "Iveco")
    public Pickup getPickupBean() {
        return new Pickup("Iveco", "EuroCargo ML100E18", 4.0, Pickup.LoadCapacity.N1);
    }

    @Bean(name = "Scania")
    public Bus getBusBean() {
        return new Bus("Scania", "Higer A80", 5.3, Bus.BusCapacity.LARGE);
    }

    @Bean(name = "Driver_Michael")
    public Driver<Car> getDriverB() {
        return new Driver<>("Michael", 5, Driver.TypeDriverLicence.B, getCarBean());
    }

    @Bean(name = "Driver_Ivan")
    public Driver<Pickup> getDriverC() {
        return new Driver<>("Alex", 16, Driver.TypeDriverLicence.C, getPickupBean());
    }

    @Bean(name = "Driver_Alex")
    public Driver<Bus> getDriverD() {
        return new Driver<>("Alex", 12, Driver.TypeDriverLicence.D, getBusBean());
    }

}

