package in.upcode.demojsonxml.controller;

import in.upcode.demojsonxml.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    CarRepository carRepository;
    @GetMapping
    public ResponseEntity getAllCars(){
        return ResponseEntity.ok(carRepository.findAll());

    } @GetMapping("/with-owner")
    public ResponseEntity getAllCarsWithOwnerName(){
        return ResponseEntity.ok(carRepository.findAllPersonNameWithCars());

    }

}
