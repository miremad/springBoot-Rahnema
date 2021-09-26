package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Model.Exception.EntityNotFoundException;
import com.example.demo.Model.Exception.InvalidInputException;
import com.example.demo.Model.Post;
import com.example.demo.Repository.CarRepository;
import com.example.demo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostRepository repo;

    @Autowired
    public PostController(PostRepository _repo) {

        this.repo = _repo;
    }

    @GetMapping("/getAll")
    public Iterable<Post> getAll()
    {
        return this.repo.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Post> get(@PathVariable("id") long id) throws EntityNotFoundException
    {
        return repo.findById(id);
    }

    @PostMapping("/add")
    public void addPost(@RequestBody Post post) throws InvalidInputException
    {

        this.repo.save(post);
    }

    @PutMapping("/edit")
    public void editPost(@RequestBody Post post) throws InvalidInputException
    {
        this.repo.save(post);
    }

    @DeleteMapping("/delete/{id}")
    public void DeletePost(@PathVariable("id") long id)
    {
        this.repo.deleteById(id);



    }
}
