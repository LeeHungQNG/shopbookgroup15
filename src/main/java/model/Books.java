package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	private long id_Category;
	private String nameBook;
	private String description;
	private String imageDisplay;
	private double priceBook;
	private int discount;
	private int id_author;
	private int status;
	private Date outputDate;
	private String styles;
	private int amount;
	private String addressOut;
	
	public Books() {
		super();
	}
	public Books(long id, long id_Category, String nameBook, String description, String imageDisplay, double priceBook,
			int discount, int id_author, int status, Date outputDate, String styles, int amount, String addressOut) {
		super();
		this.id = id;
		this.id_Category = id_Category;
		this.nameBook = nameBook;
		this.description = description;
		this.imageDisplay = imageDisplay;
		this.priceBook = priceBook;
		this.discount = discount;
		this.id_author = id_author;
		this.status = status;
		this.outputDate = outputDate;
		this.styles = styles;
		this.amount = amount;
		this.addressOut = addressOut;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_Category() {
		return id_Category;
	}
	public void setId_Category(long id_Category) {
		this.id_Category = id_Category;
	}
	public String getNameBook() {
		return nameBook;
	}
	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageDisplay() {
		return imageDisplay;
	}
	public void setImageDisplay(String imageDisplay) {
		this.imageDisplay = imageDisplay;
	}
	public double getPriceBook() {
		return priceBook;
	}
	public void setPriceBook(double priceBook) {
		this.priceBook = priceBook;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getId_author() {
		return id_author;
	}
	public void setId_author(int id_author) {
		this.id_author = id_author;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getOutputDate() {
		return outputDate;
	}
	public void setOutputDate(Date outputDate) {
		this.outputDate = outputDate;
	}
	public String getStyles() {
		return styles;
	}
	public void setStyles(String styles) {
		this.styles = styles;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getAddressOut() {
		return addressOut;
	}
	public void setAddressOut(String addressOut) {
		this.addressOut = addressOut;
	}
	
}
