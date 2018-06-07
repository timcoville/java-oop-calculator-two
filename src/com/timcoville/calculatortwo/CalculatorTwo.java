package com.timcoville.calculatortwo;
import java.util.ArrayList;

public class CalculatorTwo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Object> operands = new ArrayList<Object>();
	private Double results;
	
	public CalculatorTwo() {}
	
	public void performOperation(Double num) {
		if (operands.size() == 0) {
			operands.add(num);
			System.out.println(operands);
		}
		else if (checkPrevious()) {
			operands.add(num);
			System.out.println(operands);
		}
		else {
			System.out.println("Please enter an operator");
		}
	}
	
	public void performOperation(int num) {
		Double number = (double) num;
		if (operands.size() == 0) {
			operands.add(number);
			System.out.println(operands);
		}
		else if (checkPrevious()) {
			checkPrevious();
			operands.add(number);
			System.out.println(operands);
		}
		else {
			System.out.println("Please enter an operator");
		}
	}
	
	public void performOperation(String operator) {
		if (operands.size() == 0) {
			System.out.println("Please enter a value");
		}
		else if (operator == "+" || operator == "-" || operator == "/" || operator == "*") {
			
			if  (checkPrevious()) {
				System.out.println("Please enter a value");
			}
			else {
				operands.add(operator);
				System.out.println(operands);
			}
		}
		
		
		
		
		
		
		else if (operator == "=") {
			
			if  (checkPrevious()) {
				System.out.println("Please enter a value to calculate results");
			}
			
			else {
				while(operands.size() > 2) {
					System.out.println("List Length: " + operands.size());
					if (operands.indexOf("/") > -1 && operands.indexOf("*") > -1) {
						if (operands.indexOf("/") < operands.indexOf("*")) {
							division();
						}
						else if (operands.indexOf("/") > operands.indexOf("*")) {
							multiplication();
						}
					}
					else if (operands.indexOf("/") > -1) {
						division();
					}
					else if (operands.indexOf("*") > -1) { 
						multiplication();
					}
					else if (operands.indexOf("+") > -1 && operands.indexOf("-") > -1) {
						if (operands.indexOf("+") < operands.indexOf("-")) {
							addition();
						}
						else if (operands.indexOf("+") > operands.indexOf("-")) {
							subtraction();
						}
					}
					else if (operands.indexOf("+") > -1) {
						addition();
					}
					else if (operands.indexOf("-") > -1) { 
						subtraction();
					}		
				}
				results = (Double) operands.get(0);
				operands.remove(0);
			}
		}	
		else {
			System.out.println("Operation not valid");
		}
	}
	
	private void division() {
		Double operandOne = (Double) operands.get(operands.indexOf("/")-1);
		Double operandTwo = (Double) operands.get(operands.indexOf("/")+1);
		Double calcValue = operandOne / operandTwo;
		System.out.println("Before Division: " + operands);
		operands.set(operands.indexOf("/")-1, calcValue);
		operands.remove(operands.indexOf("/")+1);
		operands.remove(operands.indexOf("/"));
		System.out.println("After Division: " + operands);
	}
	
	private void multiplication() {
		Double operandOne = (Double) operands.get(operands.indexOf("*")-1);
		Double operandTwo = (Double) operands.get(operands.indexOf("*")+1);
		Double calcValue = operandOne * operandTwo;
		System.out.println("Before Multiplication: " + operands);
		operands.set(operands.indexOf("*")-1, calcValue);
		operands.remove(operands.indexOf("*")+1);
		operands.remove(operands.indexOf("*"));
		System.out.println("Before Multiplication: " + operands);
	}
	
	private void addition() {
		Double operandOne = (Double) operands.get(operands.indexOf("+")-1);
		Double operandTwo = (Double) operands.get(operands.indexOf("+")+1);
		Double calcValue = operandOne + operandTwo;
		System.out.println("Before Addition: " + operands);
		operands.set(operands.indexOf("+")-1, calcValue);
		operands.remove(operands.indexOf("+")+1);
		operands.remove(operands.indexOf("+"));
		System.out.println("After Addition: " + operands);
	}
	
	private void subtraction() {
		Double operandOne = (Double) operands.get(operands.indexOf("-")-1);
		Double operandTwo = (Double) operands.get(operands.indexOf("-")+1);
		Double calcValue = operandOne - operandTwo;
		System.out.println("Before Subtraction: " + operands);
		operands.set(operands.indexOf("-")-1, calcValue);
		operands.remove(operands.indexOf("-")+1);
		operands.remove(operands.indexOf("-"));
		System.out.println("After Subtraction: " + operands);
	}
	
	public void getResults() {
		if (results == null) {
			System.out.println("Please fix inputs");
		}
		else {
			System.out.println("Sum: " + results);
		}
	}
	
	private Boolean checkPrevious() {
		Boolean previous = (operands.get(operands.size()-1) == "+" || operands.get(operands.size()-1) == "-" || operands.get(operands.size()-1) == "/" || operands.get(operands.size()-1) == "*");
		return previous;
	}
	
	
	
}
