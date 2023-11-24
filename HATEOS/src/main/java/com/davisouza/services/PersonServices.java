package com.davisouza.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.davisouza.controllers.PersonController;
import com.davisouza.data.vo.v1.PersonVO;
import com.davisouza.exceptions.RequireObjectIsNullException;
import com.davisouza.exceptions.ResourceNotFoundException;
import com.davisouza.mapper.DozerMapper;
import com.davisouza.model.Person;
import com.davisouza.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<PersonVO> findAll() {

		logger.info("Finding all people!");

		var persons = DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
		persons.stream()
			.forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
		return persons;
	}

	public PersonVO findById(Long id) {

		logger.info("Finding one person!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		var vo = DozerMapper.parseObject(entity, PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());

		return vo;
	}

	public PersonVO create(PersonVO person) {
		
		if(person == null) throw new RequireObjectIsNullException();

		logger.info("Create one person!");

		Person entity = DozerMapper.parseObject(person, Person.class);

		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());

		return vo;
	}

	public PersonVO update(PersonVO person) {
		
		if(person == null) throw new RequireObjectIsNullException();

		logger.info("Update one person!");

		var personFound = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		personFound.setFirstName(person.getFirstName());
		personFound.setLastName(person.getLastName());
		personFound.setAddress(person.getAddress());
		personFound.setGender(person.getGender());

		var vo = DozerMapper.parseObject(repository.save(personFound), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());

		return vo;
	}

	public void delete(Long id) {

		logger.info("Deleting one person!");

		var personFound = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		repository.delete(personFound);
	}
}
