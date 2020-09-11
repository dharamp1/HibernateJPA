package com.sterlite.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 2nd Sep 2020
 */
@Entity
public class Flag {
	
	@Id
	private int flagId;
	
	private String description;
	
	// Owning side(which contains foreign key) of relationship
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "COUNTRY_ID") private Country country;
	 */
	
	// Non-Owning side : Does not own foreign key column
	@OneToOne(mappedBy = "flag")
	private Country country;
	
	public Flag() {
		// TODO Auto-generated constructor stub
	}
	
	public Flag(int flagId, String description) {
		super();
		this.flagId = flagId;
		this.description = description;
	}

	public int getFlagId() {
		return flagId;
	}

	public void setFlagId(int flagId) {
		this.flagId = flagId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	

}
