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
public class Motherboard {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String manufacturer;
	private String title;
	private String socket;
	private String chipset;
	private String memory_operation_mode;
	private int number_of_pci_sixteen;
	private int number_of_pci_eigth;
	private int number_of_pci_four;
	private int number_of_sata;
	private String firewire;
	
	private double listPrice;
	private double ourPrice;
	private String warranty;
	private String description;
	private int inStockNumber;
	private boolean active=true;
	@Transient
	private MultipartFile laptopImage;
	
	@OneToMany(mappedBy = "motherboard", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<CartItem> motherboardToCartItemList;
	
	public Motherboard() {
		super();
	}


	
	
	public List<CartItem> getMotherboardToCartItemList() {
		return motherboardToCartItemList;
	}




	public void setMotherboardToCartItemList(List<CartItem> motherboardToCartItemList) {
		this.motherboardToCartItemList = motherboardToCartItemList;
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


	public String getChipset() {
		return chipset;
	}


	public void setChipset(String chipset) {
		this.chipset = chipset;
	}


	public String getMemory_operation_mode() {
		return memory_operation_mode;
	}


	public void setMemory_operation_mode(String memory_operation_mode) {
		this.memory_operation_mode = memory_operation_mode;
	}


	public int getNumber_of_pci_sixteen() {
		return number_of_pci_sixteen;
	}


	public void setNumber_of_pci_sixteen(int number_of_pci_sixteen) {
		this.number_of_pci_sixteen = number_of_pci_sixteen;
	}


	public int getNumber_of_pci_eigth() {
		return number_of_pci_eigth;
	}


	public void setNumber_of_pci_eigth(int number_of_pci_eigth) {
		this.number_of_pci_eigth = number_of_pci_eigth;
	}


	public int getNumber_of_pci_four() {
		return number_of_pci_four;
	}


	public void setNumber_of_pci_four(int number_of_pci_four) {
		this.number_of_pci_four = number_of_pci_four;
	}


	public int getNumber_of_sata() {
		return number_of_sata;
	}


	public void setNumber_of_sata(int number_of_sata) {
		this.number_of_sata = number_of_sata;
	}


	public String getFirewire() {
		return firewire;
	}


	public void setFirewire(String firewire) {
		this.firewire = firewire;
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
