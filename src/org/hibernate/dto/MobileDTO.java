package org.hibernate.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "mobile_table")
public class MobileDTO implements Serializable {

	@Id
	@GenericGenerator(name = "xx", strategy = "increment")
	@GeneratedValue(generator = "xx")
	@Column(name = "mobile_id")
	private int id;
	@Column(name = "mobile_model")
	private String model;
	@Column(name = "mobile_brand")
	private String brand;
	@Column(name = "mobile_price")
	private double price;
	
	@ManyToMany(mappedBy ="mobileDTOs" , cascade = {CascadeType.PERSIST , CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH} ,fetch =FetchType.EAGER)
	private List<ApplicationDTO> applicationDTOs;

	public MobileDTO() {
		System.out.println(this.getClass().getSimpleName() + " Object Created");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<ApplicationDTO> getApplicationDTOs() {
		return applicationDTOs;
	}

	public void setApplicationDTOs(List<ApplicationDTO> applicationDTOs) {
		this.applicationDTOs = applicationDTOs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationDTOs == null) ? 0 : applicationDTOs.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + id;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
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
		MobileDTO other = (MobileDTO) obj;
		if (applicationDTOs == null) {
			if (other.applicationDTOs != null)
				return false;
		} else if (!applicationDTOs.equals(other.applicationDTOs))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (id != other.id)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

}
