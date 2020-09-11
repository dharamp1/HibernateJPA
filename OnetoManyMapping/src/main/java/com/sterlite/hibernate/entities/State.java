package com.sterlite.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 2nd Sep 2020
 */
@Entity
public class State {
	
	@Id
	private int stateId;
	
	@Column(length = 30)
	private String name;
	
	// Owning Side (which contains foreign key) - Bidirectional
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "COUN_ID") private Country country;
	 * 
	 * public Country getCountry() { return country; }
	 * 
	 * public void setCountry(Country country) { this.country = country; }
	 */

	public State() {
		// TODO Auto-generated constructor stub
	}

	public State(int stateId, String name) {
		super();
		this.stateId = stateId;
		this.name = name;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", name=" + name + "]";
	}

}
