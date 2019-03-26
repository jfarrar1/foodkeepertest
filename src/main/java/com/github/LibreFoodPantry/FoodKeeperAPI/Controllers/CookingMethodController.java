package com.github.LibreFoodPantry.FoodKeeperAPI.Controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.github.LibreFoodPantry.FoodKeeperAPI.Database;
import com.github.LibreFoodPantry.FoodKeeperAPI.Models.CookingMethod;

@RestController
public class CookingMethodController {
	private Map<Integer, CookingMethod> cookingMethodDb = Database.getCookingMethodDb();
	
	@GetMapping(value = "/cookingMethods")
	public ResponseEntity<Object> getAllCookingMethods() {
		if (cookingMethodDb != null) {
			return new ResponseEntity<>(cookingMethodDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Cooking Method database not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/cookingMethods/{id}")
	public ResponseEntity<Object> getCookingMethodById(@PathVariable("id") Integer id) {
		if (cookingMethodDb.containsKey(id)) {
			return new ResponseEntity<>(cookingMethodDb.get(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Cooking Method does not exist", HttpStatus.NOT_FOUND);
		}
	}
}
