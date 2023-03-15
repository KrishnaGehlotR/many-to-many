package org.hibernate.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "app_table")
public class ApplicationDTO implements Serializable {

	@Id
	@GenericGenerator(name = "xx", strategy = "increment")
	@GeneratedValue(generator = "xx")
	@Column(name = "app_id")
	private int appId;
	@Column(name = "version")
	private double version;
	@Column(name = "type")
	private String type;
	@Column(name = "app_name")
	private String appName;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinTable(name = "mobile_application_table", 
					joinColumns = @JoinColumn(name = "application_id"),
					inverseJoinColumns = @JoinColumn(name = "m_id"))
	private List<MobileDTO> mobileDTOs;

	public ApplicationDTO() {
		System.out.println(this.getClass().getSimpleName() + " Object Created");
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public List<MobileDTO> getMobileDTOs() {
		return mobileDTOs;
	}

	public void setMobileDTOs(List<MobileDTO> mobileDTOs) {
		this.mobileDTOs = mobileDTOs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + appId;
		result = prime * result + ((appName == null) ? 0 : appName.hashCode());
		result = prime * result + ((mobileDTOs == null) ? 0 : mobileDTOs.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		long temp;
		temp = Double.doubleToLongBits(version);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationDTO other = (ApplicationDTO) obj;
		if (appId != other.appId)
			return false;
		if (appName == null) {
			if (other.appName != null)
				return false;
		} else if (!appName.equals(other.appName))
			return false;
		if (mobileDTOs == null) {
			if (other.mobileDTOs != null)
				return false;
		} else if (!mobileDTOs.equals(other.mobileDTOs))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (Double.doubleToLongBits(version) != Double.doubleToLongBits(other.version))
			return false;
		return true;
	}

}
