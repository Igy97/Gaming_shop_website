package com.gamingshop.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Processor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String manufacturer;
	private String title;
	private String socket;
	private int number_of_core;
	private String max_consumption;
	private String integrated_graphics;
	private String clock_speed;
	private String mark;
	private String production_technology;
	
	private double listPrice;
	private double ourPrice;
	private String description;
	private int inStockNumber;
	private boolean active=true;
	private String warranty;
	@Transient
	
	
	private MultipartFile ProcessorImage;
	
	@OneToMany(mappedBy = "processor", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<CartItem> processorToCartItemList;
	
	
	public Processor() {
		super();
	}
	
	
	
	public List<CartItem> getProcessorToCartItemList() {
		return processorToCartItemList;
	}



	public void setProcessorToCartItemList(List<CartItem> processorToCartItemList) {
		this.processorToCartItemList = processorToCartItemList;
	}


	

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
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
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	public int getNumber_of_core() {
		return number_of_core;
	}
	public void setNumber_of_core(int number_of_core) {
		this.number_of_core = number_of_core;
	}
	public String getMax_consumption() {
		return max_consumption;
	}
	public void setMax_consumption(String max_consumption) {
		this.max_consumption = max_consumption;
	}
	public String getIntegrated_graphics() {
		return integrated_graphics;
	}
	public void setIntegrated_graphics(String integrated_graphics) {
		this.integrated_graphics = integrated_graphics;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	public MultipartFile getProcessorImage() {
		return ProcessorImage;
	}
	public void setProcessorImage(MultipartFile processorImage) {
		ProcessorImage = processorImage;
	}
	public String getClock_speed() {
		return clock_speed;
	}
	public void setClock_speed(String clock_speed) {
		this.clock_speed = clock_speed;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getProduction_technology() {
		return production_technology;
	}
	public void setProduction_technology(String production_technology) {
		this.production_technology = production_technology;
	}
	
	
	
	
	

}
