package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	private String nameDisplay;
	private String username;
	private String pass;
	private String role;
	private String email;
	private long idBills;
	private String sex;
	private String datebirth;
	private String address;
	public Users() {
		super();
	}
	public Users(long id, String nameDisplay, String username, String pass, String role, String email, long idBills,
			String sex, String datebirth, String address) {
		super();
		this.id = id;
		this.nameDisplay = nameDisplay;
		this.username = username;
		this.pass = pass;
		this.role = role;
		this.email = email;
		this.idBills = idBills;
		this.sex = sex;
		this.datebirth = datebirth;
		this.address = address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameDisplay() {
		return nameDisplay;
	}
	public void setNameDisplay(String nameDisplay) {
		this.nameDisplay = nameDisplay;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getIdBills() {
		return idBills;
	}
	public void setIdBills(long idBills) {
		this.idBills = idBills;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDatebirth() {
		return datebirth;
	}
	public void setDatebirth(String datebirth) {
		this.datebirth = datebirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}