package com.nzoudy;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.nzoudy.business.ProductServiceImpl;
import com.nzoudy.model.Product;

@WebService(endpointInterface="com.nzoudy.ProductCatalogInterface",
			portName="TestMartCatalogPort", 
			serviceName="TestMartCatalogService")
public class ProductCatalog implements ProductCatalogInterface {

	ProductServiceImpl productService = new ProductServiceImpl();
	
	/* (non-Javadoc)
	 * @see com.nzoudy.ProductCatalogInterface#getProductCategories()
	 */
	@Override
	public List<String> getProductCategories(){
		return productService.getProductCategories();
	}
	
	/* (non-Javadoc)
	 * @see com.nzoudy.ProductCatalogInterface#getProducts(java.lang.String)
	 */
	@Override
	public List<String> getProducts(String category){
		return productService.getProducts(category);
	}
	
	/* (non-Javadoc)
	 * @see com.nzoudy.ProductCatalogInterface#addProduct(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addProduct(String category, String product){
		return productService.addProduct(category, product);
	} 
	
	/* (non-Javadoc)
	 * @see com.nzoudy.ProductCatalogInterface#getProductsv2(java.lang.String)
	 */
	@Override
	public List<Product> getProductsv2(String category){
		return productService.getProductsv2(category);
	}
	
} 
