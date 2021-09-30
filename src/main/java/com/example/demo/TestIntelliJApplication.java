package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class TestIntelliJApplication implements CommandLineRunner {

    final PostRepository postRepo;
    final PersonRepository personRepo;
    final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public  TestIntelliJApplication(PostRepository _prepo, PersonRepository _personrepo, UserRepository ur) {

        this.postRepo = _prepo;
        this.personRepo = _personrepo;
        this.userRepository = ur;

    }

    public static void main(String[] args) {
        SpringApplication.run(TestIntelliJApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.print("---------------------------run----------");
        Person person = new Person((long)1, "miremad");
        this.personRepo.save(person);

        Post post = new Post((long) 1, new Date(), "first", "iohihihihi", person );
        this.postRepo.save(post);

        Iterable<Post> posts = this.postRepo.findAll();

        for(Post p : posts)
        {
            System.out.println(p);
        }

        User user = new User(1L, "admin", passwordEncoder.encode("admin"),
                true, "admin", 12, new ArrayList<>());
        userRepository.save(user);


        for (User u: userRepository.findAll()) {
            System.out.println(u);
        }


    }
}
