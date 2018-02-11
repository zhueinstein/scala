package com.learn.entity;

public class Category {

	private String categoryCode;
	private String categoryName;
	private Integer layer;
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getLayer() {
		return layer;
	}
	public void setLayer(Integer layer) {
		this.layer = layer;
	}
}
