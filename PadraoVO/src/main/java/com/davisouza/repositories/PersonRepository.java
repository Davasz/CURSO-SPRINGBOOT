package com.davisouza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davisouza.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
