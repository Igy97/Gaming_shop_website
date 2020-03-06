package com.gamingshop.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Laptop 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String manufacturer;
	private String display;
	private String resolution;
	private String Ram;
	private String battery;
	private String type_hdd;
	private String processor;
	private String graphics_card;
	private String hdd;
	
	private double listPrice;
	private double ourPrice;
	private String warranty;
	private String description;
	private int inStockNumber;
	private boolean active=true;
	@Transient
	private MultipartFile laptopImage;
	
	
	@OneToMany(mappedBy = "laptop", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<CartItem> laptopToCartItemList;
	
	
	public Laptop() {
		super();
	}

	
	
	
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}




	public List<CartItem> getLaptopToCartItemList() {
		return laptopToCartItemList;
	}



	public void setLaptopToCartItemList(List<CartItem> laptopToCartItemList) {
		this.laptopToCartItemList = laptopToCartItemList;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getInStockNumber() {
		return inStockNumber;
	}

	public void setInStockNumber(int inStockNumber) {
		this.inStockNumber = inStockNumber;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getGraphics_card() {
		return graphics_card;
	}

	public void setGraphics_card(String graphics_card) {
		this.graphics_card = graphics_card;
	}

	public String getHdd() {
		return hdd;
	}

	public void setHdd(String hdd) {
		this.hdd = hdd;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public MultipartFile getLaptopImage() {
		return laptopImage;
	}

	public void setLaptopImage(MultipartFile laptopImage) {
		this.laptopImage = laptopImage;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getRam() {
		return Ram;
	}

	public void setRam(String ram) {
		Ram = ram;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getType_hdd() {
		return type_hdd;
	}

	public void setType_hdd(String type_hdd) {
		this.type_hdd = type_hdd;
	}


	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public double getOurPrice() {
		return ourPrice;
	}

	public void setOurPrice(double ourPrice) {
		this.ourPrice = ourPrice;
	}
	
	
	
	
	
	
	
	
	
	
	
}
