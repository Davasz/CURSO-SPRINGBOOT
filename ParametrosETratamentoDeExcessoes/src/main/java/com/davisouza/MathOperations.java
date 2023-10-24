package com.davisouza;

public class MathOperations {
	
	public Double sum(String numberOne, String numberTwo) {
		MathValidations.twoNumbersValidation(numberOne, numberTwo);
		return MathValidations.convertToDouble(numberOne) + MathValidations.convertToDouble(numberTwo);
	}
	
	public Double sub(String numberOne, String numberTwo) {
		MathValidations.twoNumbersValidation(numberOne, numberTwo);
		return MathValidations.convertToDouble(numberOne) - MathValidations.convertToDouble(numberTwo);
	}
	
	public Double mult(String numberOne, String numberTwo) {
		MathValidations.twoNumbersValidation(numberOne, numberTwo);
		return MathValidations.convertToDouble(numberOne) * MathValidations.convertToDouble(numberTwo);
	}
	
	public Double div(String numberOne, String numberTwo) {
		MathValidations.twoNumbersValidation(numberOne, numberTwo);
		return MathValidations.convertToDouble(numberOne) / MathValidations.convertToDouble(numberTwo);
	}
	
	public Double media(String numberOne, String numberTwo) {
		MathValidations.twoNumbersValidation(numberOne, numberTwo);
		return (MathValidations.convertToDouble(numberOne) + MathValidations.convertToDouble(numberTwo)) / 2;
	}
	
	public Double raiz(String number) {
		MathValidations.isNumeric(number);
		return Math.sqrt(MathValidations.convertToDouble(number)); 
	}
}
