package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "province")
public class Province {
	@Id
	@Column(name = "provinceid")
	private String provinceid;
	private String name;
	public Province() {
		super();
	}
	public Province(String provinceid, String name) {
		super();
		this.provinceid = provinceid;
		this.name = name;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}