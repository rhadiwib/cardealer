package com.car.cardealer.service;

import com.car.cardealer.entity.Car;
import com.car.cardealer.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Flux<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Mono<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Flux<Car> searchCars(String make, String model, Integer year, String color) {
        return carRepository.searchCars(make, model, year, color);
    }

    public Mono<Car> saveCar(Car car) {
        return carRepository.save(car);
    }
}