package com.capgemini.salesmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

import com.capgemini.salesmanagement.beans.Product;
import com.capgemini.salesmanagement.utility.DataConnection;

public class ProductDaoImpl implements ProductDao{
	DataConnection dataConnection=new DataConnection();
	Connection connection=dataConnection.connect();
	
	
	
	public Product getProductDetails(int productCode) {
		Product product=null;
		
			   try {
			PreparedStatement preparedStatement=connection.prepareStatement("select * from product where product_code=?");
			
			preparedStatement.setInt(1, productCode);
			
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next())
			{
				
					product=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5));
					return product;
				
			}
			   }
			
		   catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		   
		return product;
	}

	public boolean insertSalesDetails(Product product) {
		boolean check=false;
		Random random=new Random();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("insert into sales(sales_id,product_code,quantity,sales_date,total) values(?,?,?,?,?)");
			preparedStatement.setInt(1,random.nextInt() );
			preparedStatement.setInt(2,product.getProductCode());
			preparedStatement.setInt(3, product.getQuantity());
			preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
			preparedStatement.setLong(5, (product.getProductPrice()*product.getQuantity()));
			
			int i=preparedStatement.executeUpdate();
			if(i==1)
				check=true;
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check;
	}

	
	
	
}
