package com.sterlite.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 1st Sep 2020
 */
@Embeddable
public class Name {
	
	@Column(name = "FIRST_NAME",length = 30)
	private String firstName;
	
	@Column(name = "MIDDLE_NAME",length = 30)
	private String middleName;
	
	@Column(name = "SURNAME",length = 20)
	private String lastName;
	
	public Name() {
		// TODO Auto-generated constructor stub
	}
	
	public Name(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return firstName + " " + middleName + " " + lastName;
	}
}
