package com.davisouza;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	
	private final MathOperations op = new MathOperations();
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) {
		
		return op.sum(numberOne, numberTwo);
	}
	
	@GetMapping("/sub/{numberOne}/{numberTwo}")
	public Double sub(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) {
		
		return op.sub(numberOne, numberTwo);
	}
	
	@GetMapping("/mult/{numberOne}/{numberTwo}")
	public Double mult(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) {
		
		return op.mult(numberOne, numberTwo);
	}

	@GetMapping("/div/{numberOne}/{numberTwo}")
	public Double div(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) {
		
		return op.div(numberOne, numberTwo);
	}
	
	@GetMapping("/media/{numberOne}/{numberTwo}")
	public Double media(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) {
		
		return op.media(numberOne, numberTwo);
	}
	
	@GetMapping("/raiz/{number}")
	public Double raiz(
			@PathVariable(value = "number") String number
			) {
		
		return op.raiz(number);
	}
	
}
