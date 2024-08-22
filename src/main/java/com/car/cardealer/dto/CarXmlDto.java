package com.car.cardealer.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarXmlDto {
    @XmlElement
    private Long id;
    @XmlElement
    private String make;
    @XmlElement
    private String model;
    @XmlElement
    private Integer year;
    @XmlElement
    private Double length;
    @XmlElement
    private Double weight;
    @XmlElement
    private Integer velocity;
    @XmlElement
    private String color;
    @XmlElement
    private Double price;
}