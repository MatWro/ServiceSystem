package carServiceSystem.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import carServiceSystem.entity.Car;
import carServiceSystem.entity.CarNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import carServiceSystem.repository.CarRepository;

import jakarta.validation.Valid;

@RestController
public class CarController {

    private CarRepository carRepository;

    public CarController(CarRepository carRepository){
        this.carRepository = carRepository;
    }



    @GetMapping("/jpa/Car")
    public List<Car> retrieveAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/jpa/car/{id}")
    public EntityModel<Car> retrieveUser(@PathVariable long id) {
        Optional<Car> user = carRepository.findById(id);

        if(user.isEmpty())
            throw new CarNotFoundException("id:"+id);

        EntityModel<Car> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllCars());
        entityModel.add(link.withRel("all-cars"));

        return entityModel;
    }


    @PostMapping("/jpa/Car")
    public ResponseEntity<Car> createCar(@Valid @RequestBody Car car) {


        Car savedCar = carRepository.save(car);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCar.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/jpa/car/{id}")
    public void deleteUser(@PathVariable int id) {
        carRepository.deleteById(Long.valueOf(id));
    }
}
