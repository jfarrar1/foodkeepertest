package com.github.LibreFoodPantry.FoodKeeperAPI.Controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.github.LibreFoodPantry.FoodKeeperAPI.Database;
import com.github.LibreFoodPantry.FoodKeeperAPI.Models.Category;

@RestController
public class CategoryController {
	private static Map<Integer, Category> categoryDb = Database.getCategoryDb();
	
	@GetMapping(value = "/categories")
	public ResponseEntity<Object> getAllCategories() {
		if (categoryDb != null) {
			return new ResponseEntity<>(categoryDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Category database not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/categories/{id}")
	public ResponseEntity<Object> getCategoryById(@PathVariable("id") Integer id) {
		if (categoryDb.containsKey(id)) {
			return new ResponseEntity<>(categoryDb.get(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Category does not exist", HttpStatus.NOT_FOUND);
		}
	}
}
