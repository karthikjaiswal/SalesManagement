package com.capgemini.salesmanagement.dao;

import com.capgemini.salesmanagement.beans.Product;

public interface ProductDao {

	Product getProductDetails(int productCode);
	boolean insertSalesDetails(Product product);
}
