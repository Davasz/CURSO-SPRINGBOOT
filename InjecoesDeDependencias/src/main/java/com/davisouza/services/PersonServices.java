package com.davisouza.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.davisouza.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong couter = new AtomicLong();
	private Logger logger = Logger
			.getLogger(PersonServices.class.getName());
	
		public List<Person> findAll() {
			List<Person> persons = new ArrayList<Person>();
			
			logger.info("Finding all people!");
			for(int i = 0; i < 8; i++) {
				Person person = mockPerson(i);
				persons.add(person);
			}
			return persons;
		}

		public Person findById(String id) {
		
			logger.info("Finding one person!");
			
			Person person = new Person();
			
			person.setId(couter.incrementAndGet());
			person.setFirstName("Davi");
			person.setLastName("Souza");
			person.setAddress("São Paulo");
			person.setGender("Male");
			
			return person;
	}
		
		public Person create(Person person) {
			
			logger.info("Create one person!");
			
			return person;
		}
		
		public Person update(Person person) {
			
			logger.info("Update one person!");
			
			return person;
		}
		
		public void delete(String id) {
			logger.info("Deleting one person!");
		}
		

		private Person mockPerson(int i) {
			Person person = new Person();
			
			person.setId(couter.incrementAndGet());
			person.setFirstName("Person name" + i);
			person.setLastName("Last name" + i);
			person.setAddress("Address" + i);
			person.setGender("Male");
			
			return person;
		}
}
