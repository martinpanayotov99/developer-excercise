package com.cloudruid.supermarket.entity;

public class ClientOrder {
	
	private String items;
	private String prices;
	private String promotion1;
	private String promotion2;
	
	
	public ClientOrder() {
		
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getPrices() {
		return prices;
	}
	public void setPrices(String prices) {
		this.prices = prices;
	}
	public String getPromotion1() {
		return promotion1;
	}
	public void setPromotion1(String promotion1) {
		this.promotion1 = promotion1;
	}
	public String getPromotion2() {
		return promotion2;
	}
	public void setPromotion2(String promotion2) {
		this.promotion2 = promotion2;
	}
	
	
	

}
