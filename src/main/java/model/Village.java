package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "village")
public class Village {
	@Id
	@Column(name = "villageid")
	private String villageid;
	private String name;
	private String wardid;

	public Village() {
		super();
	}

	public Village(String villageid, String name, String wardid) {
		super();
		this.villageid = villageid;
		this.name = name;
		this.wardid = wardid;
	}

	public String getVillageid() {
		return villageid;
	}

	public void setVillageid(String villageid) {
		this.villageid = villageid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWardid() {
		return wardid;
	}

	public void setWardid(String wardid) {
		this.wardid = wardid;
	}

}
