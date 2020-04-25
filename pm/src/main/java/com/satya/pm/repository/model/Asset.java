package com.satya.pm.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Asset {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String type;//Land, Building
	private Double estimatedValue;
	private Double sellingPrice;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the estimatedValue
	 */
	public Double getEstimatedValue() {
		return estimatedValue;
	}
	/**
	 * @param estimatedValue the estimatedValue to set
	 */
	public void setEstimatedValue(Double estimatedValue) {
		this.estimatedValue = estimatedValue;
	}
	/**
	 * @return the sellingPrice
	 */
	public Double getSellingPrice() {
		return sellingPrice;
	}
	/**
	 * @param sellingPrice the sellingPrice to set
	 */
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	@Override
	public String toString() {
		return "Asset [id=" + id + ", name=" + name + ", type=" + type + ", estimatedValue=" + estimatedValue
				+ ", sellingPrice=" + sellingPrice + "]";
	}

}
