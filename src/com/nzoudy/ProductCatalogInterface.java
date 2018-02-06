package com.nzoudy;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.nzoudy.model.Product;

@WebService(name="TestMartCatalog", targetNamespace="http://www.testmart.com")
public interface ProductCatalogInterface {

	@WebMethod(action="fetch_categories", operationName="fetchCategories")
	public List<String> getProductCategories();

	@WebMethod
	public List<String> getProducts(String category);

	@WebMethod
	public boolean addProduct(String category, String product);

	@WebMethod
	@WebResult(name="Product")
	public List<Product> getProductsv2(String category);

}