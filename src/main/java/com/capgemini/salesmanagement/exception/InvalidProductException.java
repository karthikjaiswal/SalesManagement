package com.capgemini.salesmanagement.exception;

public class InvalidProductException extends Exception{

	public InvalidProductException()
	{
		System.err.println("ERROR: Invalid Product Code");
	}
}
