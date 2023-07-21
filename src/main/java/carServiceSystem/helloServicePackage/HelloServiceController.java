package carServiceSystem.helloServicePackage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloServiceController {

    @GetMapping(path = "/")
    public String helloWorld(){
        return "Hello Service Java";
    }
}
