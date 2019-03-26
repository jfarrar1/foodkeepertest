package com.github.LibreFoodPantry.FoodKeeperAPI.Models;

public class ShelfLife {	
	private Integer min;
	private Integer max;
	private String metric;
	private String tips;
	
	public ShelfLife() {}
	
	public ShelfLife(Integer min, Integer max, String metric, String tips) {
		this.min = min;
		this.max = max;
		this.metric = metric;
		this.tips = tips;
	}
	
	public Integer getMin() {
		return min;
	}
	
	public void setMin(Integer min) {
		this.min = min;
	}
	
	public Integer getMax() {
		return max;
	}
	
	public void setMax(Integer max) {
		this.max = max;
	}
	
	public String getMetric() {
		return metric;
	}
	
	public void setMetric(String metric) {
		this.metric = metric;
	}
	
	public String getTips() {
		return tips;
	}
	
	public void setTips(String tips) {
		this.tips = tips;
	}

	@Override
	public String toString() {
		return "ShelfLife [min=" + min + ", max=" + max + ", metric=" + metric + ", tips=" + tips;
	}
}
