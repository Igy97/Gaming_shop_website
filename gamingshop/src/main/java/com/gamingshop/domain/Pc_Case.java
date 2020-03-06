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
public class Pc_Case {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String manufacturer;
	private String title;
	private String type_of_case;
	private String type_of_motherboard;
	private boolean transparent_side;
	private String material;
	private int number_of_usb;
	
	private double listPrice;
	private double ourPrice;
	private String warranty;
	private String description;
	private int inStockNumber;
	private boolean active=true;
	@Transient
	private MultipartFile laptopImage;
	
	@OneToMany(mappedBy = "pc_Case", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<CartItem> pc_CaseToCartItemList;
	
	
	
	public Pc_Case() {
		super();
	}
	
	
	
	public List<CartItem> getPc_CaseToCartItemList() {
		return pc_CaseToCartItemList;
	}



	public void setPc_CaseToCartItemList(List<CartItem> pc_CaseToCartItemList) {
		this.pc_CaseToCartItemList = pc_CaseToCartItemList;
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
	public String getType_of_case() {
		return type_of_case;
	}
	public void setType_of_case(String type_of_case) {
		this.type_of_case = type_of_case;
	}
	public String getType_of_motherboard() {
		return type_of_motherboard;
	}
	public void setType_of_motherboard(String type_of_motherboard) {
		this.type_of_motherboard = type_of_motherboard;
	}
	public boolean isTransparent_side() {
		return transparent_side;
	}
	public void setTransparent_side(boolean transparent_side) {
		this.transparent_side = transparent_side;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getNumber_of_usb() {
		return number_of_usb;
	}
	public void setNumber_of_usb(int number_of_usb) {
		this.number_of_usb = number_of_usb;
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
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
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
	public MultipartFile getLaptopImage() {
		return laptopImage;
	}
	public void setLaptopImage(MultipartFile laptopImage) {
		this.laptopImage = laptopImage;
	}
	
	
	
}
