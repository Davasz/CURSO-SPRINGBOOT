package com.davisouza.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davisouza.data.vo.v1.PersonVO;
import com.davisouza.data.vo.v2.PersonVOV2;
import com.davisouza.exceptions.ResourceNotFoundException;
import com.davisouza.mapper.DozerMapper;
import com.davisouza.mapper.custom.PersonMapper;
import com.davisouza.model.Person;
import com.davisouza.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll() {

		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {

		logger.info("Finding one person!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		return DozerMapper.parseObject(entity, PersonVO.class);
	}

	public PersonVO create(PersonVO person) {

		logger.info("Create one person!");

		Person entity = DozerMapper.parseObject(person, Person.class);

		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

		return vo;
	}

	public PersonVOV2 createV2(PersonVOV2 person) {
		
		logger.info("Create one person V2!");
		
		Person entity = mapper.convertVoToEntity(person);
		
		var vo = mapper.convertEntityToVo(repository.save(entity));
		
		return vo;
	}

	public PersonVO update(PersonVO person) {

		logger.info("Update one person!");

		var personFound = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		personFound.setFirstName(person.getFirstName());
		personFound.setLastName(person.getLastName());
		personFound.setAddress(person.getAddress());
		personFound.setGender(person.getGender());

		var vo = DozerMapper.parseObject(repository.save(personFound), PersonVO.class);

		return vo;
	}

	public void delete(Long id) {

		logger.info("Deleting one person!");

		var personFound = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		repository.delete(personFound);
	}
}
