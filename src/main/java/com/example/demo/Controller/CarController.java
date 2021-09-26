package com.example.demo.Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.Model.Car;
import com.example.demo.Model.Exception.EntityNotFoundException;
import com.example.demo.Model.Exception.InvalidInputException;
import com.example.demo.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/car")
public class CarController {
    

    private final CarRepository repo;


    public CarController(CarRepository _repo) {

        this.repo = _repo;
    }

    @GetMapping("/getAll")
    public Collection<Car> getAll()
    {
        return this.repo.getAll();
    }

    @GetMapping("/get/{id}")
    public Car get(@PathVariable("id") Integer id) throws EntityNotFoundException
    {
        return repo.get(id);
    }

    @PostMapping("/add")
    public void addCar(@Valid @RequestBody Car car) throws InvalidInputException
    {
        this.repo.addOrUpdate(car);
    }

    @PutMapping("/edit")
    public void editCar(@RequestBody Car car) throws InvalidInputException
    {
        repo.addOrUpdate(car);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteCar(@PathVariable("id") Integer id)
    {
        repo.Delete(id);

    }
}
