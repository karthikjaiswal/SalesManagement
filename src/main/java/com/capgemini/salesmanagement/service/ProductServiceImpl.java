package com.capgemini.salesmanagement.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.capgemini.salesmanagement.beans.Product;
import com.capgemini.salesmanagement.dao.ProductDao;
import com.capgemini.salesmanagement.dao.ProductDaoImpl;
import com.capgemini.salesmanagement.utility.DataConnection;



public class ProductServiceImpl implements ProductService{
	
	DataConnection dataConnection=new DataConnection();
	ProductDao productDao=new ProductDaoImpl();
	Scanner sc=new Scanner(System.in);
	public Product getProductDetails(int productCode) {
		
		return productDao.getProductDetails(productCode);
		 
	}

	public boolean insertSalesDetails(Product product) {
		
		return productDao.insertSalesDetails(product);
	}
	public boolean validateProduct(int productCode)
	{
		boolean check = false;
		
		Connection connection=dataConnection.connect();
		try {
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery("select * from product");
			while(rs.next())
			{
				if(rs.getInt(1)==productCode)
				{
				check = true;
				break;
				}
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check;
	}

}
