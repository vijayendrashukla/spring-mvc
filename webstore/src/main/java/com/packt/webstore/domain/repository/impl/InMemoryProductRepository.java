package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository{

	private List<Product> listOfProducts = new ArrayList<Product>();
	
	public InMemoryProductRepository () {
		Product iPhone = new Product("P1234", "iPhone 6s", new BigDecimal(500));
		iPhone.setDescription("Apple iPhone 6s smartphone with 5.00-inch 640*1136 display and 8-megapixel rear camera");
		iPhone.setCategory("Smart Phone");
		iPhone.setManufacturer("Apple");
		iPhone.setUnitsInStock(1000);
		
		Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
		laptop_dell.setDescription("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors");
		laptop_dell.setCategory("Laptop");
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setUnitsInStock(1000);
		
		Product tablet_Nexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
		tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch tablet with a quad-core Qualcomm Snapdragon S4 Pro processor");
		tablet_Nexus.setCategory("Tablet");
		tablet_Nexus.setManufacturer("Google");
		tablet_Nexus.setUnitsInStock(1000);
		
		listOfProducts.add(iPhone);
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_Nexus);
	}
	
	public List <Product> getAllProducts(){
		return listOfProducts;
	}
	
	public Product getProductById(String productId){
		Product productById = null;
		
		for(Product product: listOfProducts){
			if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
				productById = product;
				break;
			}
		}
		
		if (productById == null){
			throw new IllegalArgumentException("No products found with the product id: " + productId);
		}
		
		return productById;
	}
}
