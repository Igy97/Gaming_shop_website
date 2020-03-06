package com.adminportal_gamingshop.domain;

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
public class Graphics_Card {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String manufacturer;
	private String title;
	private String graphics_interface;
	private String clock_memory;
	private String clock_processor;
	private String type_of_memory;
	private String capacity_of_memory;
	private int number_of_hdmi;
	private int number_of_vga;
	private int number_of_display_port;
	
	
	private double listPrice;
	private double ourPrice;
	private String description;
	private int inStockNumber;
	private boolean active=true;
	private String warranty;
	@Transient
	private MultipartFile GraphicsImage;
	
	
	@OneToMany(mappedBy = "graphics_Card", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<CartItem> graphics_CardToCartItemList;
	
	
	public Graphics_Card() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public List<CartItem> getGraphics_CardToCartItemList() {
		return graphics_CardToCartItemList;
	}


	public void setGraphics_CardToCartItemList(List<CartItem> graphics_CardToCartItemList) {
		this.graphics_CardToCartItemList = graphics_CardToCartItemList;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public String getGraphics_interface() {
		return graphics_interface;
	}


	public void setGraphics_interface(String graphics_interface) {
		this.graphics_interface = graphics_interface;
	}


	public String getClock_memory() {
		return clock_memory;
	}


	public void setClock_memory(String clock_memory) {
		this.clock_memory = clock_memory;
	}


	public String getClock_processor() {
		return clock_processor;
	}


	public void setClock_processor(String clock_processor) {
		this.clock_processor = clock_processor;
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


	public MultipartFile getGraphicsImage() {
		return GraphicsImage;
	}


	public void setGraphicsImage(MultipartFile graphicsImage) {
		GraphicsImage = graphicsImage;
	}


	public String getType_of_memory() {
		return type_of_memory;
	}


	public void setType_of_memory(String type_of_memory) {
		this.type_of_memory = type_of_memory;
	}


	public String getCapacity_of_memory() {
		return capacity_of_memory;
	}


	public void setCapacity_of_memory(String capacity_of_memory) {
		this.capacity_of_memory = capacity_of_memory;
	}


	public int getNumber_of_hdmi() {
		return number_of_hdmi;
	}


	public void setNumber_of_hdmi(int number_of_hdmi) {
		this.number_of_hdmi = number_of_hdmi;
	}


	public int getNumber_of_vga() {
		return number_of_vga;
	}


	public void setNumber_of_vga(int number_of_vga) {
		this.number_of_vga = number_of_vga;
	}


	public int getNumber_of_display_port() {
		return number_of_display_port;
	}


	public void setNumber_of_display_port(int number_of_display_port) {
		this.number_of_display_port = number_of_display_port;
	}


	
	


	
	
	
	

	
}
