package com.virak.tdd.controller;

import com.virak.tdd.domain.Car;
import com.virak.tdd.exception.CarNotFoundException;
import com.virak.tdd.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name) {
        return carService.getCarDetails(name);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    private void carNotFoundHandler(CarNotFoundException ex) {
    }

}
