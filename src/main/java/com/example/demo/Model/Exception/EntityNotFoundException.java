package com.example.demo.Model.Exception;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityNotFoundException extends Exception{
    
    private String message;
    private Integer id;

    public EntityNotFoundException(Integer id)
    {
        super("Not Found");
        this.id = id;
    }

    public Integer getId()
    {
        return this.id;
    }

}
