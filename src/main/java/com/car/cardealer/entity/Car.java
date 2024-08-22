package com.car.cardealer.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("cars")
public class Car {
    @Id
    private Long id;
    private String make;
    private String model;
    private Integer year;
    private Double length;
    private Double weight;
    private Integer velocity;
    private String color;
    private Double price;
}