package com.sterlite.hibernate.entites.emp.mgr;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.sterlite.hibernate.entites.emp.Employee;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 1st Sep 2020
 */
@Entity
@Table(name = "MANAGER_MASTER_J")
@PrimaryKeyJoinColumn(name = "MGR_ID")
public class Manager extends Employee {
	
	private BigDecimal incentives;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getIncentives() {
		return incentives;
	}

	public void setIncentives(BigDecimal incentives) {
		this.incentives = incentives;
	}

	@Override
	public String toString() {
		return "Manager [incentives=" + incentives + "]";
	}
}
