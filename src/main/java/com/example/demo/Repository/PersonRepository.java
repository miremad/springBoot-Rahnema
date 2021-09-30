package com.example.demo.repository;


import com.example.demo.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Collection<Person> findByNameContaining(String name);

}
