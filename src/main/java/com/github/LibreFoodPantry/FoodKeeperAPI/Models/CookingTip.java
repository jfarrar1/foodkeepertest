package com.github.LibreFoodPantry.FoodKeeperAPI.Models;

import java.util.Map;

import com.github.LibreFoodPantry.FoodKeeperAPI.JsonConverter;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class CookingTip {
	private Integer id;
	private Integer productId;
	private String tips;
	private Integer safeMinTemp;
	private Integer restTime;
	private String restTimeMetric;
	
	public CookingTip() {}
	
	public CookingTip(Integer id, Integer productID, String tips, Integer safeMinTemp, Integer restTime,
			String restTimeMetric) {
		this.id = id;
		this.productId = productID;
		this.tips = tips;
		this.safeMinTemp = safeMinTemp;
		this.restTime = restTime;
		this.restTimeMetric = restTimeMetric;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getProductID() {
		return productId;
	}

	public void setProductID(Integer productID) {
		this.productId = productID;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public Integer getSafeMinTemp() {
		return safeMinTemp;
	}

	public void setSafeMinTemp(Integer safeMinTemp) {
		this.safeMinTemp = safeMinTemp;
	}

	public Integer getRestTime() {
		return restTime;
	}

	public void setRestTime(Integer restTime) {
		this.restTime = restTime;
	}

	public String getRestTimeMetric() {
		return restTimeMetric;
	}

	public void setRestTimeMetric(String restTimeMetric) {
		this.restTimeMetric = restTimeMetric;
	}

	@Override
	public String toString() {
		return "CookingTip [id=" + id + ", productID=" + productId + ", tips=" + tips + ", safeMinTemp=" + safeMinTemp
				+ ", restTime=" + restTime + ", restTimeMetric=" + restTimeMetric + "]";
	}
	
	public static CookingTip getFromJsonArray(JsonArray jsonArr) {
		Map<String, JsonElement> map = JsonConverter.getMapFromJsonArray(jsonArr);
		CookingTip newCookingTip = new CookingTip();
		
		newCookingTip.id = JsonConverter.getJsonElementAsInt(map.get("ID"));
		newCookingTip.productId = JsonConverter.getJsonElementAsInt(map.get("Product_ID"));
		newCookingTip.tips = JsonConverter.getJsonElementAsString(map.get("Tips"));
		newCookingTip.safeMinTemp = JsonConverter.getJsonElementAsInt(map.get("Safe_Minimum_Temperature"));
		newCookingTip.restTime = JsonConverter.getJsonElementAsInt(map.get("Rest_Time"));
		newCookingTip.restTimeMetric = JsonConverter.getJsonElementAsString(map.get("Rest_Time_metric"));
		
		return newCookingTip;
	}
}
