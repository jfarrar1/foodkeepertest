package com.github.LibreFoodPantry.FoodKeeperAPI.Models;

import java.util.Map;

import com.github.LibreFoodPantry.FoodKeeperAPI.JsonConverter;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class Product {
	private Integer id;
	private Integer categoryId;
	private String name;
	private String subtitle;
	private String keywords;
	private ShelfLife pantryLife;
	private ShelfLife DOP_pantryLife;
	private ShelfLife pantryAfterOpeningLife;
	private ShelfLife refrigeratorLife;
	private ShelfLife DOP_refrigeratorLife;
	private ShelfLife refrigerateAfterOpeningLife;
	private ShelfLife refrigerateAfterThawingLife;
	private ShelfLife freezerLife;
	private ShelfLife DOP_freezerLife;
	
	public Product() {}
	
	public Product(Integer id, Integer categoryId, 
			String name, String subtitle, String keywords,
			ShelfLife pantryLife, ShelfLife DOP_pantryLife, ShelfLife pantryAfterOpenLife,
			ShelfLife refrigeratorLife, ShelfLife DOP_refrigeratorLife,
			ShelfLife refrigerateAfterOpeningLife, ShelfLife refrigerateAfterThawingLife,
			ShelfLife freezerLife, ShelfLife DOP_freezerLife) {
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.subtitle = subtitle;
		this.keywords = keywords;
		this.pantryLife = pantryLife;
		this.DOP_pantryLife = DOP_pantryLife;
		this.pantryAfterOpeningLife = pantryAfterOpenLife;
		this.refrigeratorLife = refrigeratorLife;
		this.DOP_refrigeratorLife = DOP_refrigeratorLife;
		this.refrigerateAfterOpeningLife = refrigerateAfterOpeningLife;
		this.refrigerateAfterThawingLife = refrigerateAfterThawingLife;
		this.freezerLife = freezerLife;
		this.DOP_freezerLife = DOP_freezerLife;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public ShelfLife getPantryLife() {
		return pantryLife;
	}

	public void setPantryLife(ShelfLife pantryLife) {
		this.pantryLife = pantryLife;
	}

	public ShelfLife getDOP_pantryLife() {
		return DOP_pantryLife;
	}

	public void setDOP_pantryLife(ShelfLife dOP_pantryLife) {
		DOP_pantryLife = dOP_pantryLife;
	}

	public ShelfLife getPantryAfterOpeningLife() {
		return pantryAfterOpeningLife;
	}

	public void setPantryAfterOpeningLife(ShelfLife pantryAfterOpeningLife) {
		this.pantryAfterOpeningLife = pantryAfterOpeningLife;
	}

	public ShelfLife getRefrigeratorLife() {
		return refrigeratorLife;
	}

	public void setRefrigeratorLife(ShelfLife refrigeratorLife) {
		this.refrigeratorLife = refrigeratorLife;
	}

	public ShelfLife getDOP_refrigeratorLife() {
		return DOP_refrigeratorLife;
	}

	public void setDOP_refrigeratorLife(ShelfLife dOP_refrigeratorLife) {
		DOP_refrigeratorLife = dOP_refrigeratorLife;
	}

	public ShelfLife getRefrigerateAfterOpeningLife() {
		return refrigerateAfterOpeningLife;
	}

	public void setRefrigerateAfterOpeningLife(ShelfLife refrigerateAfterOpeningLife) {
		this.refrigerateAfterOpeningLife = refrigerateAfterOpeningLife;
	}

	public ShelfLife getRefrigerateAfterThawingLife() {
		return refrigerateAfterThawingLife;
	}

	public void setRefrigerateAfterThawingLife(ShelfLife refrigerateAfterThawingLife) {
		this.refrigerateAfterThawingLife = refrigerateAfterThawingLife;
	}

	public ShelfLife getFreezerLife() {
		return freezerLife;
	}

	public void setFreezerLife(ShelfLife freezerLife) {
		this.freezerLife = freezerLife;
	}

	public ShelfLife getDOP_freezerLife() {
		return DOP_freezerLife;
	}

	public void setDOP_freezerLife(ShelfLife dOP_freezerLife) {
		DOP_freezerLife = dOP_freezerLife;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", subtitle=" + subtitle
				+ ", keywords=" + keywords + ", pantryLife=" + pantryLife + ", DOP_pantryLife=" + DOP_pantryLife
				+ ", pantryAfterOpenLife=" + pantryAfterOpeningLife + ", refrigeratorLife=" + refrigeratorLife
				+ ", DOP_refrigeratorLife=" + DOP_refrigeratorLife + ", refrigerateAfterOpeningLife="
				+ refrigerateAfterOpeningLife + ", refrigerateAfterThawingLife=" + refrigerateAfterThawingLife
				+ ", freezerLife=" + freezerLife + ", DOP_freezerLife=" + DOP_freezerLife + "]";
	}
	
	public static Product getFromJsonArray(JsonArray jsonArr) {
		Map<String, JsonElement> map = JsonConverter.getMapFromJsonArray(jsonArr);
		Product newProduct = new Product();
		
		newProduct.id = JsonConverter.getJsonElementAsInt(map.get("ID"));
		newProduct.categoryId = JsonConverter.getJsonElementAsInt(map.get("Category_ID"));
		newProduct.name = JsonConverter.getJsonElementAsString(map.get("Name"));
		newProduct.subtitle = JsonConverter.getJsonElementAsString(map.get("Name_subtitle"));
		newProduct.keywords = JsonConverter.getJsonElementAsString(map.get("Keywords"));
		
		newProduct.pantryLife = new ShelfLife();
		newProduct.pantryLife.setMin(JsonConverter.getJsonElementAsInt(map.get("Pantry_Min")));
		newProduct.pantryLife.setMax(JsonConverter.getJsonElementAsInt(map.get("Pantry_Max")));
		newProduct.pantryLife.setMetric(JsonConverter.getJsonElementAsString(map.get("Pantry_Metric")));
		newProduct.pantryLife.setTips(JsonConverter.getJsonElementAsString(map.get("Pantry_tips")));
		
		newProduct.DOP_pantryLife = new ShelfLife();
		newProduct.DOP_pantryLife.setMin(JsonConverter.getJsonElementAsInt(map.get("DOP_Pantry_Min")));
		newProduct.DOP_pantryLife.setMax(JsonConverter.getJsonElementAsInt(map.get("DOP_Pantry_Max")));
		newProduct.DOP_pantryLife.setMetric(JsonConverter.getJsonElementAsString(map.get("DOP_Pantry_Metric")));
		newProduct.DOP_pantryLife.setTips(JsonConverter.getJsonElementAsString(map.get("DOP_Pantry_tips")));
		
		newProduct.pantryAfterOpeningLife = new ShelfLife();
		newProduct.pantryAfterOpeningLife.setMin(JsonConverter.getJsonElementAsInt(map.get("Pantry_After_Opening_Min")));
		newProduct.pantryAfterOpeningLife.setMax(JsonConverter.getJsonElementAsInt(map.get("Pantry_After_Opening_Max")));
		newProduct.pantryAfterOpeningLife.setMetric(JsonConverter.getJsonElementAsString(map.get("Pantry_After_Opening_Metric")));
		newProduct.pantryAfterOpeningLife.setTips(JsonConverter.getJsonElementAsString(map.get("Pantry_After_Opening_tips")));
		
		newProduct.refrigeratorLife = new ShelfLife();
		newProduct.refrigeratorLife.setMin(JsonConverter.getJsonElementAsInt(map.get("Refrigerate_Min")));
		newProduct.refrigeratorLife.setMax(JsonConverter.getJsonElementAsInt(map.get("Refrigerate_Max")));
		newProduct.refrigeratorLife.setMetric(JsonConverter.getJsonElementAsString(map.get("Refrigerate_Metric")));
		newProduct.refrigeratorLife.setTips(JsonConverter.getJsonElementAsString(map.get("Refrigerate_tips")));
		
		newProduct.DOP_refrigeratorLife = new ShelfLife();
		newProduct.DOP_refrigeratorLife.setMin(JsonConverter.getJsonElementAsInt(map.get("DOP_Refrigerate_Min")));
		newProduct.DOP_refrigeratorLife.setMax(JsonConverter.getJsonElementAsInt(map.get("DOP_Refrigerate_Max")));
		newProduct.DOP_refrigeratorLife.setMetric(JsonConverter.getJsonElementAsString(map.get("DOP_Refrigerate_Metric")));
		newProduct.DOP_refrigeratorLife.setTips(JsonConverter.getJsonElementAsString(map.get("DOP_Refrigerate_tips")));
		
		newProduct.refrigerateAfterOpeningLife = new ShelfLife();
		newProduct.refrigerateAfterOpeningLife.setMin(JsonConverter.getJsonElementAsInt(map.get("Refrigerate_After_Opening_Min")));
		newProduct.refrigerateAfterOpeningLife.setMax(JsonConverter.getJsonElementAsInt(map.get("Refrigerate_After_Opening_Max")));
		newProduct.refrigerateAfterOpeningLife.setMetric(JsonConverter.getJsonElementAsString(map.get("Refrigerate_After_Opening_Metric")));
		newProduct.refrigerateAfterOpeningLife.setTips(JsonConverter.getJsonElementAsString(map.get("Refrigerate_After_Opening_tips")));
		
		newProduct.refrigerateAfterThawingLife = new ShelfLife();
		newProduct.refrigerateAfterThawingLife.setMin(JsonConverter.getJsonElementAsInt(map.get("Refrigerate_After_Thawing_Min")));
		newProduct.refrigerateAfterThawingLife.setMax(JsonConverter.getJsonElementAsInt(map.get("Refrigerate_After_Thawing_Max")));
		newProduct.refrigerateAfterThawingLife.setMetric(JsonConverter.getJsonElementAsString(map.get("Refrigerate_After_Thawing_Metric")));
		newProduct.refrigerateAfterThawingLife.setTips(JsonConverter.getJsonElementAsString(map.get("Refrigerate_After_Thawing_tips")));
		
		newProduct.freezerLife = new ShelfLife();
		newProduct.freezerLife.setMin(JsonConverter.getJsonElementAsInt(map.get("Freeze_Min")));
		newProduct.freezerLife.setMax(JsonConverter.getJsonElementAsInt(map.get("Freeze_Max")));
		newProduct.freezerLife.setMetric(JsonConverter.getJsonElementAsString(map.get("Freeze_Metric")));
		newProduct.freezerLife.setTips(JsonConverter.getJsonElementAsString(map.get("Freeze_tips")));
		
		newProduct.DOP_freezerLife = new ShelfLife();
		newProduct.DOP_freezerLife.setMin(JsonConverter.getJsonElementAsInt(map.get("DOP_Freeze_Min")));
		newProduct.DOP_freezerLife.setMax(JsonConverter.getJsonElementAsInt(map.get("DOP_Freeze_Max")));
		newProduct.DOP_freezerLife.setMetric(JsonConverter.getJsonElementAsString(map.get("DOP_Freeze_Metric")));
		newProduct.DOP_freezerLife.setTips(JsonConverter.getJsonElementAsString(map.get("DOP_Freeze_tips")));
		
		return newProduct;
	}
}
