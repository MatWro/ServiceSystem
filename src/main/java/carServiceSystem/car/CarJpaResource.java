package carServiceSystem.car;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import carServiceSystem.jpa.CarRepository;

import jakarta.validation.Valid;

@RestController
public class CarJpaResource {

    private CarRepository carRepository;

    public CarJpaResource(CarRepository carRepository){
        this.carRepository = carRepository;
    }



    @GetMapping("/jpa/Car")
    public List<Car> retrieveAllUsers() {
        return carRepository.findAll();
    }
    @GetMapping("/jpa/cars/{id}")
    public EntityModel<Car> retrieveUser(@PathVariable int id) {
        Optional<Car> user = carRepository.findById(id);

        if(user.isEmpty())
            throw new CarNotFoundException("id:"+id);

        EntityModel<Car> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

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
}
