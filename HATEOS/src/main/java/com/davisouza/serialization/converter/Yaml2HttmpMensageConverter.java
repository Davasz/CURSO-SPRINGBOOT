package com.davisouza.serialization.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class Yaml2HttmpMensageConverter extends AbstractJackson2HttpMessageConverter {

	public Yaml2HttmpMensageConverter() {
		super(new YAMLMapper().setSerializationInclusion(
				JsonInclude.Include.NON_NULL),
				MediaType.parseMediaType("application/x-yaml"));
	}
	
}
