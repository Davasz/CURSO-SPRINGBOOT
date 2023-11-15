package com.davisouza.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.davisouza.data.vo.v2.PersonVOV2;
import com.davisouza.model.Person;

@Service
public class PersonMapper {

	public PersonVOV2 convertEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setBirthday(new Date());
		vo.setFirstName(person.getFirstName());
		vo.setGender(person.getGender());
		vo.setLastName(person.getLastName());
		
		return vo;
	}
	
	public Person convertVoToEntity(PersonVOV2 person) {
		Person vo = new Person();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setFirstName(person.getFirstName());
		vo.setGender(person.getGender());
		vo.setLastName(person.getLastName());
		
		return vo;
	}
}
