package com.car.cardealer.controller;

import com.car.cardealer.dto.CarXmlDto;
import com.car.cardealer.dto.CarsXmlDto;
import com.car.cardealer.entity.Car;
import com.car.cardealer.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public Flux<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Mono<Car> getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/search")
    public Flux<Car> searchCars(@RequestParam(required = false) String make,
                                @RequestParam(required = false) String model,
                                @RequestParam(required = false) Integer year,
                                @RequestParam(required = false) String color) {
        return carService.searchCars(make, model, year, color);
    }

    @PostMapping
    public Mono<Car> addCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @GetMapping(value = "/download", produces = MediaType.APPLICATION_XML_VALUE)
    public Mono<ResponseEntity<CarsXmlDto>> downloadCarsXml(
            @RequestParam(required = false) String make,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String color) {
        return carService.searchCars(make, model, year, color)
                .collectList()
                .map(cars -> {
                    CarsXmlDto xmlDto = new CarsXmlDto();
                    xmlDto.setCars(cars.stream()
                            .map(this::convertToCarXmlDto)
                            .collect(Collectors.toList()));
                    return ResponseEntity.ok()
                            .contentType(MediaType.APPLICATION_XML)
                            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=cars.xml")
                            .body(xmlDto);
                });
    }

    private CarXmlDto convertToCarXmlDto(Car car) {
        CarXmlDto dto = new CarXmlDto();
        BeanUtils.copyProperties(car, dto);
        return dto;
    }
}