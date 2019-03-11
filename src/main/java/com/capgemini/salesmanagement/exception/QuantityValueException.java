package com.capgemini.salesmanagement.exception;

public class QuantityValueException extends Exception{

	public QuantityValueException()
	{
		System.out.println("ERROR: Quantity shuold be greater than zero");
	}
}
