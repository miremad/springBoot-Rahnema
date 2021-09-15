package com.example.demo.Repository;

import com.example.demo.Model.Car;
import com.example.demo.Model.Exception.EntityNotFoundException;

import java.util.Collection;

public interface CarRepository {
    
    void addOrUpdate(Car car);
    Car get(Integer id) throws EntityNotFoundException;
    void Delete(Integer id);
    Collection<Car> getAll();

    
}
