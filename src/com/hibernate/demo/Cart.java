package com.hibernate.demo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="carts")
public class Cart {
	
	@Id
	@Column(name = "cart_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "cart_name", nullable = false)
	private String name;
	
	@Column(name = "total")
	private double total;
	
	@OneToMany(mappedBy = "cart")
	private Set<Item> items;


	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cart(long id, String name, double total, Set<Item> items) {
		super();
		this.id = id;
		this.name = name;
		this.total = total;
		this.items = items;
	}


	public Cart(String name, double total, Set<Item> items) {
		super();
		this.name = name;
		this.total = total;
		this.items = items;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public Set<Item> getItem() {
		return items;
	}


	public void setItem(Set<Item> items) {
		this.items = items;
	}


	@Override
	public String toString() {
		return "Cart [id=" + id + ", name=" + name + ", total=" + total + ", item=" + items + "]";
	} 

	
	
}
