package com.davisouza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davisouza.data.vo.v1.PersonVO;
import com.davisouza.services.PersonServices;
import com.davisouza.util.MediaType;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

	@Autowired
	private PersonServices service;

	@GetMapping(value = "/{id}", produces = {MediaType.JSON, MediaType.XML, MediaType.YAML})
	public PersonVO findById(@PathVariable(value = "id") Long id) {

		return service.findById(id);
	}

	@GetMapping(produces = {MediaType.JSON, MediaType.XML, MediaType.YAML})
	public List<PersonVO> findALl() {

		return service.findAll();
	}

	@PostMapping(produces = {MediaType.JSON, MediaType.XML, MediaType.YAML}, consumes = {MediaType.JSON, MediaType.XML, MediaType.YAML})
	public PersonVO create(@RequestBody PersonVO person) {

		return service.create(person);
	}

	@PutMapping(produces = {MediaType.JSON, MediaType.XML, MediaType.YAML})
	public PersonVO uptade(@RequestBody PersonVO person) {

		return service.update(person);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
