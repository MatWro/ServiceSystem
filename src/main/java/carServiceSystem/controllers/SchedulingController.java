package carServiceSystem.controllers;


import carServiceSystem.entity.FixRequest;
import carServiceSystem.repository.CarRepository;
import carServiceSystem.repository.SchedulingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchedulingController {
    private SchedulingRepository schedulingRepository;

    public SchedulingController(SchedulingRepository schedulingRepository){
        this.schedulingRepository = schedulingRepository;
    }
    @GetMapping("/schedules")
    public List<FixRequest> retrieveAllFixRequests(){
        return schedulingRepository.findAll();
    }
}
