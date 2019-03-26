package com.github.LibreFoodPantry.FoodKeeperAPI.Controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.github.LibreFoodPantry.FoodKeeperAPI.Database;
import com.github.LibreFoodPantry.FoodKeeperAPI.Models.CookingTip;

@RestController
public class CookingTipController {
	private Map<Integer, CookingTip> cookingTipDb = Database.getCookingTipDb();
	
	@GetMapping(value = "/cookingTips")
	public ResponseEntity<Object> getAllCookingTips() {
		if (cookingTipDb != null) {
			return new ResponseEntity<>(cookingTipDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Cooking Tip database not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/cookingTips/{id}")
	public ResponseEntity<Object> getCookingTipById(@PathVariable("id") Integer id) {
		if (cookingTipDb.containsKey(id)) {
			return new ResponseEntity<>(cookingTipDb.get(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Cooking Tip does not exist", HttpStatus.NOT_FOUND);
		}
	}
}
