package com.capgemini.salesmanagement;

import java.util.Scanner;

import com.capgemini.salesmanagement.beans.Product;
import com.capgemini.salesmanagement.exception.InvalidProductException;
import com.capgemini.salesmanagement.exception.QuantityValueException;
import com.capgemini.salesmanagement.service.ProductService;
import com.capgemini.salesmanagement.service.ProductServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	static ProductService productService=new ProductServiceImpl();
	
	
    public static void main( String[] args )
    {
    	Product product=null;
    	Scanner sc=new Scanner(System.in);
      
        	System.out.println("======Billing Counter=======");
        	System.out.println("enter product code");
        	int code=sc.nextInt();
        	if(productService.validateProduct(code))
        	{
        		System.out.println("enter the quantity");
     		   int quantity=sc.nextInt();
     		   if(quantity<=0)
     		   {
     			   try {
     				throw new QuantityValueException();
     			   } catch (QuantityValueException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			   }
     			
     		   }
     		   else   
     		   {
     			   product = productService.getProductDetails(code);
     				product.setQuantity(quantity);
     		   }
        	}
        	else
        	{
        		try {
					throw new InvalidProductException();
				} catch (InvalidProductException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}	
        		
        		if(productService.insertSalesDetails(product))
        		{
        			System.out.println("Product Name: 		"+product.getProductName());
        			System.out.println("Product Category: 	"+product.getProductCategory());
        			System.out.println("Product Description:	"+product.getProductDescription());
        			System.out.println("Product Price:		"+product.getProductPrice());
        			System.out.println("Quantity:		"+product.getQuantity());
        			System.out.println("Line Total:		"+(product.getProductPrice()*product.getQuantity()));
        		}
        		else
        			System.out.println("error");
        	
        		System.out.println("=======Thank You=======");
        	    System.exit(0);
        	
        }
    
}
