package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Model.Exception.EntityNotFoundException;
import com.example.demo.Model.Exception.InvalidInputException;
import com.example.demo.Model.Person;
import com.example.demo.Repository.CarRepository;
import com.example.demo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository repo;

    @Autowired
    public PersonController(PersonRepository _repo) {

        this.repo = _repo;
    }

    @GetMapping("/getAll")
    public Iterable<Person> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                   @RequestParam(defaultValue = "10") Integer pageSize)
    {
        Pageable pageable = PageRequest.ofSize(pageSize).withPage(pageNo);
        return this.repo.findAll(pageable);
    }

    @GetMapping("/search")
    public Iterable<Person> getAll(@RequestParam(defaultValue = "") String query)
    {
        return this.repo.findAllByNameContaining(query);
    }

    @GetMapping("/get/{id}")
    public Optional<Person> get(@PathVariable("id") String id) throws EntityNotFoundException
    {

        return repo.findById(id);
    }

    @PostMapping("/add")
    public void addPerson(@RequestBody Person person) throws InvalidInputException
    {

        Person p = person;
        this.repo.save(p);


    }

    @PutMapping("/edit")
    public void editPerson(@RequestBody Person person) throws InvalidInputException
    {
        this.repo.save(person);
    }

    @DeleteMapping("/delete/{id}")
    public void DeletePerson(@PathVariable("id") String id)
    {
        this.repo.deleteById(id);

    }
}
