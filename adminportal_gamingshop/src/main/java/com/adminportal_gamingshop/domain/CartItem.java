package com.adminportal_gamingshop.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javassist.bytecode.LineNumberAttribute.Pc;

@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int qty;
	private BigDecimal subtotal;
	
	
	@ManyToOne
	private Laptop laptop;
	
	@ManyToOne
	private Graphics_Card graphics_Card;
	
	@ManyToOne
	private Processor processor;
	
	@ManyToOne
	private Motherboard motherboard;
	
	@ManyToOne
	private Pc_Case pc_Case;
	
	@ManyToOne
	private Game game;
	
//	@OneToMany(mappedBy = "cartItem")
//	@JsonIgnore
//	private List<BookToCartItem> bookToCartItemList;
	
	@ManyToOne
	@JoinColumn(name="shopping_cart_id")
	private ShoppingCart shoppingCart;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	

//	public List<BookToCartItem> getBookToCartItemList() {
//		return bookToCartItemList;
//	}
//
//	public void setBookToCartItemList(List<BookToCartItem> bookToCartItemList) {
//		this.bookToCartItemList = bookToCartItemList;
//	}
	
	

	public Laptop getLaptop() {
		return laptop;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public Graphics_Card getGraphics_Card() {
		return graphics_Card;
	}

	public void setGraphics_Card(Graphics_Card graphics_Card) {
		this.graphics_Card = graphics_Card;
	}

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	public Motherboard getMotherboard() {
		return motherboard;
	}

	public void setMotherboard(Motherboard motherboard) {
		this.motherboard = motherboard;
	}

	public Pc_Case getPc_Case() {
		return pc_Case;
	}

	public void setPc_Case(Pc_Case pc_Case) {
		this.pc_Case = pc_Case;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
