package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bills")
public class Bills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	private String nameRecevie;
	private String numberHouse;
	private String address;
	private String numberPhone;
	private String email;
	private String note;
	private Date datePay;
	private int status;
	private String total;

	public Bills() {
		super();
	}

	public Bills(long id, String nameRecevie, String numberHouse, String address, String numberPhone, String email,
			String note, Date datePay, int status, String total) {
		super();
		this.id = id;
		this.nameRecevie = nameRecevie;
		this.numberHouse = numberHouse;
		this.address = address;
		this.numberPhone = numberPhone;
		this.email = email;
		this.note = note;
		this.datePay = datePay;
		this.status = status;
		this.total = total;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameRecevie() {
		return nameRecevie;
	}

	public void setNameRecevie(String nameRecevie) {
		this.nameRecevie = nameRecevie;
	}

	public String getNumberHouse() {
		return numberHouse;
	}

	public void setNumberHouse(String numberHouse) {
		this.numberHouse = numberHouse;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getDatePay() {
		return datePay;
	}

	public void setDatePay(Date datePay) {
		this.datePay = datePay;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
}
