package com.hibernate.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
	
	@Id
	@Column(name="id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="item_id", nullable = false)
	private String itemId;
	
	@Column(name="item_name", nullable = false)
	private String name;
	
	@Column(name="total_price")
	private double totalPrice;
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "cart_id",nullable = false)
	private Cart cart;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(long id, String itemId, String name, double totalPrice, int quantity, Cart cart) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.name = name;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		this.cart = cart;
	}

	public Item(String itemId, String name, double totalPrice, int quantity, Cart cart) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		this.cart = cart;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemId=" + itemId + ", name=" + name + ", totalPrice=" + totalPrice + ", quantity="
				+ quantity + ", cart=" + cart + "]";
	}
	
    
}
