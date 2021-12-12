package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "cart") 
	private List<Item> item= new ArrayList<Item>();
	private long id_User;
	private double totalPrice;
	private int amount;


	public Cart(long id, List<Item> item, long id_User, double totalPrice, int amount) {
		super();
		this.id = id;
		this.item = item;
		this.id_User = id_User;
		this.totalPrice = totalPrice;
		this.amount = amount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Cart() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public long getId_User() {
		return id_User;
	}

	public void setId_User(long id_User) {
		this.id_User = id_User;
	}

	

	
}