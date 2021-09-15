package com.example.demo.Model;

import lombok.*;

import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {

    @NotNull
    private Integer id;
    private String name;
    private String company;
    
  

}
