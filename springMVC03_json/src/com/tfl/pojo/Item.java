package com.tfl.pojo;

public class Item {
	private Integer id;
	private String name;
	private Double price;
	private String detail;
	public Item() {
	}
	public Item(Integer id, String name, Double price, String detail) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.detail = detail;
	}
	public Item(String name, Double price, String detail) {
		super();
		this.name = name;
		this.price = price;
		this.detail = detail;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", detail=" + detail + "]";
	}
	
	
}
