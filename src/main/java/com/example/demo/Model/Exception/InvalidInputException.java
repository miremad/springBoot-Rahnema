package com.example.demo.Model.Exception;

public class InvalidInputException extends Exception  {

    private String message;
    private Integer id;

    public InvalidInputException(Integer id)
    {
        super("Invalid Data");
        this.id = id;
    }

    public Integer getId()
    {
        return this.id;
    }

}
