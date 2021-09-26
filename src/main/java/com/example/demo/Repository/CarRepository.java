package com.example.demo.Repository;

import com.example.demo.Model.Car;
import com.example.demo.Model.Exception.EntityNotFoundException;
import com.example.demo.Model.Exception.InvalidInputException;

import java.util.Collection;

public interface CarRepository {
    
    void addOrUpdate(Car car) throws InvalidInputException;
    Car get(Integer id) throws EntityNotFoundException;
    void Delete(Integer id);
    Collection<Car> getAll();

    
}
