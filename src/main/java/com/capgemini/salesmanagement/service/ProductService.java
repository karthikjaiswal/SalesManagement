package com.capgemini.salesmanagement.service;

import com.capgemini.salesmanagement.beans.Product;

public interface ProductService {

	Product getProductDetails(int productCode);
	boolean insertSalesDetails(Product product);
	boolean validateProduct(int productCode);
}
