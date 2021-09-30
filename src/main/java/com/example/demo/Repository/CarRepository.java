package com.example.demo.repository;


import com.example.demo.model.Car;
import com.example.demo.model.exception.EntityNotFoundException;


import java.util.Collection;

public interface CarRepository {

    void addOrUpdate(Car car);
    Car get(Integer id) throws EntityNotFoundException;
    void delete(Integer id);
    Collection<Car> all();

}
