package com.example.demo;

import com.example.demo.Model.Person;
import com.example.demo.Model.Post;
import com.example.demo.Repository.PersonRepository;
import com.example.demo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TestIntelliJApplication implements CommandLineRunner {

    final PostRepository postRepo;
    final PersonRepository personRepo;
    @Autowired
    public  TestIntelliJApplication(PostRepository _prepo, PersonRepository _personrepo) {

        this.postRepo = _prepo;
        this.personRepo = _personrepo;

    }

    public static void main(String[] args) {
        SpringApplication.run(TestIntelliJApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.print("---------------------------run----------");
        Person person = new Person("1", "miremad");
        this.personRepo.save(person);

        Post post = new Post(1, new Date(), "first", "iohihihihi", person );
        this.postRepo.save(post);

        Iterable<Post> posts = this.postRepo.findAll();
        for(Post p : posts)
        {
            System.out.println(p);
        }

    }
}
