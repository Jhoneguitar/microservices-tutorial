package com.tutorialmicroservicios.userservice.feignclients;

import com.tutorialmicroservicios.userservice.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name = "car-service", url = "http://localhost:8002/car")
//con eureka ya no necesitamos la url
@FeignClient(name = "car-service", path = "/car")
public interface CarFeignClient {

    @PostMapping()
    Car save(@RequestBody Car car);

    @GetMapping("/byuser/{userId}")
    List<Car> getCars(@PathVariable("userId") int userId);
}
