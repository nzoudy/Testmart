package com.nzoudy.business;

import java.util.ArrayList;
import java.util.List;

import com.nzoudy.model.Product;

public class ProductServiceImpl {

	List<String> bookList = new ArrayList<>();
	List<String> musicList = new ArrayList<>();
	List<String> movieList = new ArrayList<>();
	
	public ProductServiceImpl() {
		bookList.add("Infermo");
		bookList.add("Joy land");
		bookList.add("The game of thrones");
		
		musicList.add("Random access Memories");
		musicList.add("Night vision");
		musicList.add("Unorthodox Jukebox");
		
		movieList.add("Oz the great and powerfull");
		movieList.add("Despicable me");
		movieList.add("Star trek intro darkness");
	}
	
	public List<String> getProductCategories(){
		List<String> categories = new ArrayList<>();
		categories.add("Books");
		categories.add("Music");
		categories.add("Movies");
		return categories;
	}
	
	public List<String> getProducts(String category){
		switch(category.toLowerCase()) {
		case "books":
			return bookList;
		case "music":
			return musicList;
		case "movies":
			return movieList;
		}
		return null;
	}
	
	public boolean addProduct(String category, String product) {
		switch(category.toLowerCase()) {
		case "books":
			 bookList.add(product);
			 break;
		case "music":
			 musicList.add(product);
			 break;
		case "movies":
			 movieList.add(product);
			 break;
		default:
			return false;
		}
		return true;
		
		
	}

	public List<Product> getProductsv2(String category) {
		List<Product> products = new ArrayList<>();
		products.add(new Product("Java Nzoudy book", "9999", 23.80));
		products.add(new Product("Math book", "9349", 23.90));
		return products;
	}
	
}
