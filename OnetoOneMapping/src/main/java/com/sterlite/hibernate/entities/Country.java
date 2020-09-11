package com.sterlite.hibernate.entities;

import java.math.BigInteger;

import javax.persistence.Column;
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
public class Country {
	
	@Id
	private int id;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 30)
	private String language;
	
	@Column(precision = 12)
	private BigInteger population;
	
	// Bidirectional Relationship
	/*
	 * @OneToOne(mappedBy = "country") // mappedBy is used on non-owning side
	 * private Flag flag;
	 */

	// Owner of relationship
	@OneToOne
	@JoinColumn(name = "FLAG_ID") // foreign key column
	private Flag flag;
	
	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}
	 

	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(int id, String name, String language, BigInteger population) {
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

	public BigInteger getPopulation() {
		return population;
	}

	public void setPopulation(BigInteger population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", language=" + language + ", population=" + population + "]";
	}

}
