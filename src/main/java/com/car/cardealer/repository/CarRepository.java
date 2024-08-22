package com.car.cardealer.repository;

import com.car.cardealer.entity.Car;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CarRepository extends ReactiveCrudRepository<Car, Long> {
        @Query("SELECT * FROM cars WHERE (:make IS NULL OR make ILIKE concat('%', :make, '%')) " +
                "AND (:model IS NULL OR model ILIKE concat('%', :model, '%')) " +
                "AND (:year IS NULL OR year = :year) " +
                "AND (:color IS NULL OR color ILIKE concat('%', :color, '%'))")
        Flux<Car> searchCars(String make, String model, Integer year, String color);
}