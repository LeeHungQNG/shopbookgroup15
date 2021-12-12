package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "district")
public class District {
	@Id
	@Column(name = "districtid")
	private String districtid;
	private String name;
	private String provinceid;

	public District() {
		super();
	}

	public District(String districtid, String name, String provinceid) {
		super();
		this.districtid = districtid;
		this.name = name;
		this.provinceid = provinceid;
	}

	public String getDistrictid() {
		return districtid;
	}

	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

}
