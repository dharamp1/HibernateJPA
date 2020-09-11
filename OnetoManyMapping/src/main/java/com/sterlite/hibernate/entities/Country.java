package com.sterlite.hibernate.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 2nd Sep 2020
 */
@Entity
public class Country {
	
	@Id
	private int id;
	
	@Column(length = 30)
	private String name;
	
	@Column(length =  20)
	private String language;
	
	@Column(precision = 12)
	private BigDecimal population;
	
	// Unidirectional
	@OneToMany
	@JoinTable(name = "COUN_STATE",joinColumns = {@JoinColumn(name="COUN_ID")},inverseJoinColumns = {@JoinColumn(name="STATE_ID")})
	private List<State> states;
	
	// Bidirectional 
	// Non-owning side
	//@OneToMany(mappedBy = "country",cascade = CascadeType.ALL)// user cascade All if you want to automatically persist objects in child table
	//private List<State> states;
	
	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(int id, String name, String language, BigDecimal population) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.population = population;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public BigDecimal getPopulation() {
		return population;
	}

	public void setPopulation(BigDecimal population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", language=" + language + ", population=" + population + "]";
	}
	
	

}
