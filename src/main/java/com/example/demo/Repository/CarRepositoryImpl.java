package com.example.demo.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.Model.Car;
import com.example.demo.Model.Exception.EntityNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepositoryImpl implements CarRepository {

    private final static Map<Integer, Car> repo = new HashMap<>();

    
    public void addOrUpdate(Car car) {
        // TODO Auto-generated method stub
        System.out.println(car);
        repo.put(car.getId(), car);
    }

    
    public Car get(Integer id) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        if(!repo.containsKey(id))
        {
            throw new EntityNotFoundException(id);
        }
        return repo.get(id);

    }

    
    public void Delete(Integer id) {
        // TODO Auto-generated method stub
        repo.remove(id);
        
    }

    
    public Collection<Car> getAll() {
        // TODO Auto-generated method stub
        return repo.values();
    }
    
}
