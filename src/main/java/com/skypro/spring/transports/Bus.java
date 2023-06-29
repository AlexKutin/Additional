package com.skypro.spring.transports;

import org.springframework.stereotype.Component;

@Component("Bus")
public class Bus extends Transport {
    public enum BusCapacity {
        ESPECIALLY_SMALL(null, 10),
        SMALL(null, 25),
        AVERAGE(40, 50),
        LARGE(60, 80),
        ESPECIALLY_LARGE(100, 120);

        private final Integer from;
        private final Integer upTo;

        BusCapacity(Integer from, Integer upTo) {
            this.from = from;
            this.upTo = upTo;
        }

        @Override
        public String toString() {
            if (from == null && upTo == null) {
                return "Вместимость: не задана!";
            } else if (from != null && upTo == null) {
                return String.format("Вместимость: от %d мест", from);
            } else if (from == null) {
                return String.format("Вместимость: до %d мест", upTo);
            } else {
                return String.format("Вместимость: %d - %d мест", from, upTo);
            }
        }
    }

    private BusCapacity busCapacity;

    public BusCapacity getBusCapacity() {
        return busCapacity;
    }

    public void setBusCapacity(BusCapacity busCapacity) {
        this.busCapacity = busCapacity;
    }

    public Bus() {
    }

    public Bus(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    public Bus(String brand, String model, double engineVolume, BusCapacity busCapacity) {
        super(brand, model, engineVolume);
        this.busCapacity = busCapacity;
    }

    @Override
    public void printType() {
        if (busCapacity == null) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else {
            System.out.println(busCapacity);
        }
    }

    @Override
    public String toString() {
        return String.format("Автобус: " + super.toString());
    }
}
