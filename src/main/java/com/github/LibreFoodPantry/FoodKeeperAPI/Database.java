package com.github.LibreFoodPantry.FoodKeeperAPI;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.LibreFoodPantry.FoodKeeperAPI.Models.Category;
import com.github.LibreFoodPantry.FoodKeeperAPI.Models.CookingMethod;
import com.github.LibreFoodPantry.FoodKeeperAPI.Models.CookingTip;
import com.github.LibreFoodPantry.FoodKeeperAPI.Models.Product;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Database {
	private static Map<Integer, Category> categoryDb = new HashMap<>();	
	private static Map<Integer, Product> productDb = new HashMap<>();	
	private static Map<Integer, CookingMethod> cookingMethodDb = new HashMap<>();	
	private static Map<Integer, CookingTip> cookingTipDb = new HashMap<>();
	
	public static Map<Integer, Category> getCategoryDb() {
		return categoryDb;
	}
	
	public static Map<Integer, Product> getProductDb() {
		return productDb;
	}
	
	public static Map<Integer, CookingMethod> getCookingMethodDb() {
		return cookingMethodDb;
	}
	
	public static Map<Integer, CookingTip> getCookingTipDb() {
		return cookingTipDb;
	}
	
	public static void storeFoodKeeperData() {
		Gson gson = new Gson();
        
        try (Reader reader = new FileReader("foodkeeper.json")) {
        	JsonObject body = gson.fromJson(reader, JsonObject.class);
        	JsonArray sheets = body.get("sheets").getAsJsonArray();
        	
        	JsonObject categoriesObj = sheets.get(1).getAsJsonObject();
        	storeCategories(categoriesObj);
        	
        	JsonObject productsObj = sheets.get(2).getAsJsonObject();
        	storeProducts(productsObj);
        	
        	JsonObject cookingTipsObj = sheets.get(3).getAsJsonObject();
        	storeCookingTips(cookingTipsObj);
        	
        	JsonObject cookingMethodsObj = sheets.get(4).getAsJsonObject();
        	storeCookingMethods(cookingMethodsObj);
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
    
    static List<CookingMethod> storeCookingMethods(JsonObject obj) {
    	List<CookingMethod> list = new ArrayList<>();
    	JsonArray data = obj.get("data").getAsJsonArray();
    	for (JsonElement element : data) {
    		if (element.isJsonNull()) { continue; }
    		JsonArray cookingMethodArr = element.getAsJsonArray();
    		CookingMethod cookingMethod = CookingMethod.getFromJsonArray(cookingMethodArr);
    		cookingMethodDb.put(cookingMethod.getId(), cookingMethod);
    	}
    	return list;
    }
    
    static List<CookingTip> storeCookingTips(JsonObject obj) {
    	List<CookingTip> list = new ArrayList<>();
    	JsonArray data = obj.get("data").getAsJsonArray();
    	for (JsonElement element : data) {
    		if (element.isJsonNull()) { continue; }
    		JsonArray cookingTipsArr = element.getAsJsonArray();
    		CookingTip cookingTip = CookingTip.getFromJsonArray(cookingTipsArr);
    		cookingTipDb.put(cookingTip.getId(), cookingTip);
    	}
    	return list;
    }
    
    static List<Product> storeProducts(JsonObject obj) {
    	List<Product> list = new ArrayList<>();
    	JsonArray data = obj.get("data").getAsJsonArray();
    	for (JsonElement element : data) {
    		if (element.isJsonNull()) { continue; }
    		JsonArray productArr = element.getAsJsonArray();		
    		Product product = Product.getFromJsonArray(productArr);
    		productDb.put(product.getId(), product);
    	}
    	return list;
    }
    
    static void storeCategories(JsonObject obj) {
    	JsonArray data = obj.get("data").getAsJsonArray();
    	for (JsonElement element : data) {
    		if (element.isJsonNull()) { continue; }
    		JsonArray categoryArr = element.getAsJsonArray();
    		Category category = Category.getFromJsonArray(categoryArr);
    		categoryDb.put(category.getId(), category);
    	}
    }
}
