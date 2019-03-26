package com.github.LibreFoodPantry.FoodKeeperAPI;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonConverter {
	
	public static Double getJsonElementAsDouble(JsonElement element) {
    	Double num;
    	try {
    		num = element.getAsDouble();
    	} catch (UnsupportedOperationException | 
    			NullPointerException | 
    			NumberFormatException e) {
			num = null;
		}
    	return num;
    }
	
	public static Integer getJsonElementAsInt(JsonElement element) {
    	Integer num;
    	try {
    		num = element.getAsInt();
    	} catch (UnsupportedOperationException | 
    			NullPointerException | 
    			NumberFormatException e) {
			num = null;
		}
    	return num;
    }
    
    public static String getJsonElementAsString(JsonElement element) {
    	String s;
    	try {
    		s = element.getAsString();
    	} catch (UnsupportedOperationException | 
    			NullPointerException e) {
			s = null;
		}
    	return s;
    }
    
    public static JsonElement getFromJsonArray(JsonArray arr, int index) {
    	try {
    		return arr.get(index);
    	} catch (IndexOutOfBoundsException e) {
    		return null;
    	}
    }
    
    public static Map<String, JsonElement> getMapFromJsonArray(JsonArray jsonArr) {
    	Map<String, JsonElement> map = new HashMap<>();
		for (JsonElement element : jsonArr) {
			JsonObject obj = element.getAsJsonObject();
			Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();
			for (Map.Entry<String, JsonElement> entry : entries) {
				map.put(entry.getKey(), entry.getValue());
			}
		}
		return map;
    }
}
