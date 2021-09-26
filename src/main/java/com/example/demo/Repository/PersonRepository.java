package com.example.demo.Repository;

import com.example.demo.Model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.Collection;

public interface PersonRepository extends PagingAndSortingRepository<Person, String> {

    Collection<Person> findAllByNameContaining(String query);

}
