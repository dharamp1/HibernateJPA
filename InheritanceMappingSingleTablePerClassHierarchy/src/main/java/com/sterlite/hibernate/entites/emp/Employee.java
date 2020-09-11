package com.sterlite.hibernate.entites.emp;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 1st Sep 2020
 */
@Entity
@Table(name = "EMP_MASTER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EMP_TYPE", discriminatorType = DiscriminatorType.STRING, length = 10)
@DiscriminatorValue("EMP")
public class Employee {
	
	@Id
	@Column(name = "EMP_ID")
	@GeneratedValue
	private int empId;
	
	@Column(length = 30)
	private String name;
	
	@Column(precision = 12, scale = 2)
	private BigDecimal salary;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}
	
	

}
