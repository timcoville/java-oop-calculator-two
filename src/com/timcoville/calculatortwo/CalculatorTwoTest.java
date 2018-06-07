package com.timcoville.calculatortwo;

public class CalculatorTwoTest {
	public static void main(String[] args) {
		CalculatorTwo calc = new CalculatorTwo();
		calc.performOperation("/");
		calc.performOperation(10.5);
		calc.performOperation("*");
		calc.performOperation(10);
		calc.performOperation("+");
		calc.performOperation(7.5);
		calc.performOperation("-");
		calc.performOperation(7.5);
		calc.performOperation("/");
		calc.performOperation("/");
		calc.performOperation(2);
		calc.performOperation("*");
		calc.performOperation(2);
		calc.performOperation("=");
		calc.getResults();
		
		
	}
}
