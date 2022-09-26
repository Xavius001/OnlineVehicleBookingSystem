package com.techwave.client.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Vehicledb {
	
	private String vehicleId;
	
	private String manufactureName;
	
	private String color;
	
	private Integer seatingCapacity;
	private Integer price;
	
	private Branchdb branchId;
	private Integer stock;
	
	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getManufactureName() {
		return manufactureName;
	}

	public void setManufactureName(String manufactureName) {
		this.manufactureName = manufactureName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Branchdb getbranchId() {
		return branchId;
	}

	public void setbranchId(Branchdb branchId) {
		this.branchId = branchId;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Vehicledb(String vehicleId, String manufactureName, String color, Integer seatingCapacity, Integer price, Branchdb branchId,
			Integer stock) {
		super();
		this.vehicleId = vehicleId;
		this.manufactureName = manufactureName;
		this.color = color;
		this.seatingCapacity = seatingCapacity;
		this.price = price;
		this.branchId = branchId;
		this.stock = stock;
	}

	public Vehicledb() {}

	@Override
	public String toString() {
		String price1 = this.price.toString();
		String stock1 = this.stock.toString();
		return "Vid-"+this.vehicleId+" Manu:"+this.manufactureName+" price:"+price1+" color:"+this.color+" stock:"+stock1+" branchid:"+this.getbranchId().getbranchId().getUserId();
	}
	
	
	
}
