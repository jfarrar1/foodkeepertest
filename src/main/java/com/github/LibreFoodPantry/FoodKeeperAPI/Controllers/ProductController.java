package com.github.LibreFoodPantry.FoodKeeperAPI.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.github.LibreFoodPantry.FoodKeeperAPI.Database;
import com.github.LibreFoodPantry.FoodKeeperAPI.Models.Product;

@RestController
public class ProductController {
	private Map<Integer, Product> productDb = Database.getProductDb();
	
	@GetMapping(value = "/products")
	public ResponseEntity<Object> getAllProducts() {
		if (productDb != null) {
			return new ResponseEntity<>(productDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Product database not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/products/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable("id") Integer id) {
		if (productDb.containsKey(id)) {
			return new ResponseEntity<>(productDb.get(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Product does not exist", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/products/{id}/name")
	public ResponseEntity<Object> getProductName(@PathVariable("id") Integer id) {
		if (productDb.containsKey(id)) {
			return new ResponseEntity<>(productDb.get(id).getName(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Product does not exist", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/products/category/{categoryId}")
	public ResponseEntity<Object> getProductsWithCategoryId(@PathVariable("categoryId") Integer id) {
		List<Product> matchingProducts = new ArrayList<>();
		for (Product p : productDb.values()) {
			if (p.getCategoryId() == id) {
				matchingProducts.add(p);
			}
		}
		
		if (matchingProducts.size() > 0) { 
			return new ResponseEntity<>(matchingProducts, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No products found with categoryId: " + id, HttpStatus.NOT_FOUND);
		}
	}
}
