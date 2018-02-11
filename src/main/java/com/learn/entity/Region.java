package com.learn.entity;

import java.io.Serializable;

/**
 *  区域
 */
public class Region implements Serializable{
	private static final long serialVersionUID = 8731237026946528634L;

	private String provinceId;
	private String provinceName; // 省份名称
	private String cityId; // 城市id
	private String cityName; // 城市名称
	private String areaId; // 区域ID
	private String areaName; // 区域名称

	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}
