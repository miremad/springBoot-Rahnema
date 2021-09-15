package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String Hello()
    {
        return "Hello-Worldff";
    }

    @GetMapping("/hello1")
    public String Hello1()
    {
        return "Hello1-World";
    }
}
