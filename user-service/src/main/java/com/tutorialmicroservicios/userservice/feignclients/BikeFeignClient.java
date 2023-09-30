package com.tutorialmicroservicios.userservice.feignclients;

import com.tutorialmicroservicios.userservice.model.Bike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@FeignClient(name = "bike-service", url = "http://localhost:8003/bike")
//con eureka ya no necesitamos la url
@FeignClient(name = "bike-service", path = "/bike")
public interface BikeFeignClient {

    @PostMapping()
    Bike save(@RequestBody Bike bike);

    @GetMapping("/byuser/{userId}")
    List<Bike> getBikes(@PathVariable("userId") int userId);
}
