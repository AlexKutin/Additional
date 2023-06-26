package com.skypro.spring;

import com.skypro.spring.transports.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Driver<T extends Transport> {

    enum TypeDriverLicence {B, C, D}

    private String fullName;
    private int experience;

    private TypeDriverLicence typeDriverLicense;

    private T transport;

    public String getFullName() {
        return fullName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public TypeDriverLicence getTypeDriverLicense() {
        return typeDriverLicense;
    }

    public void setTypeDriverLicense(TypeDriverLicence typeDriverLicense) {
        this.typeDriverLicense = typeDriverLicense;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(T transport) {
        this.transport = transport;
    }

    public Driver() {
    }

    public Driver(String fullName, int experience, TypeDriverLicence typeDriverLicense) {
        this.fullName = fullName;
        this.experience = experience;
        this.typeDriverLicense = typeDriverLicense;
    }

    public Driver(String fullName, int experience, TypeDriverLicence typeDriverLicense, @Autowired T transport) {
        this.fullName = fullName;
        this.experience = experience;
        this.typeDriverLicense = typeDriverLicense;
        this.transport = transport;
    }

    @Override
    public String toString() {
        return String.format("Водитель: %s, стаж: %d, категория прав: %s, управляет транспортом: %s",
                getFullName(), getExperience(),
                typeDriverLicense == null ? "нет" : getTypeDriverLicense().name(), transport);
    }

}
