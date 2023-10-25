package com.davisouza.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davisouza.exceptions.ResourceNotFoundException;
import com.davisouza.model.Person;
import com.davisouza.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<Person> findAll() {

		logger.info("Finding all people!");

		return repository.findAll();
	}

	public Person findById(Long id) {

		logger.info("Finding one person!");

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}

	public Person create(Person person) {

		logger.info("Create one person!");

		return repository.save(person);
	}

	public Person update(Person person) {

		logger.info("Update one person!");

		Person personFound = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		personFound.setFirstName(person.getFirstName());
		personFound.setLastName(person.getLastName());
		personFound.setAddress(person.getAddress());
		personFound.setGender(person.getGender());

		return repository.save(person);
	}

	public void delete(Long id) {

		logger.info("Deleting one person!");

		Person personFound = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		repository.delete(personFound);
	}
}
