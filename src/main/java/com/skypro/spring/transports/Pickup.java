package com.skypro.spring.transports;

import org.springframework.stereotype.Component;

@Component
public class Pickup extends Transport {
    public enum LoadCapacity {
        N1(null, 3.5f),
        N2(3.5f, 12f),
        N3(12f, null);

        private final Float from;
        private final Float upTo;

        LoadCapacity(Float from, Float upTo) {
            this.from = from;
            this.upTo = upTo;
        }

        @Override
        public String toString() {
            if (from == null && upTo == null) {
                return "Грузоподъемность: не задана!";
            } else if (from != null && upTo == null) {
                return String.format("Грузоподъемность: от %.1f тонн", from);
            } else if (from == null) {
                return String.format("Грузоподъемность: до %.1f тонн", upTo);
            } else {
                return String.format("Грузоподъемность: от %.1f тонн до %.1f тонн", from, upTo);
            }
        }
    }

    private LoadCapacity loadCapacity;

    public LoadCapacity getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(LoadCapacity loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Pickup() {
    }

    public Pickup(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    public Pickup(String brand, String model, double engineVolume, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void printType() {
        if (loadCapacity == null) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else {
            System.out.println(loadCapacity);
        }
    }

    @Override
    public String toString() {
        return String.format("Пикап: " + super.toString());
    }

}