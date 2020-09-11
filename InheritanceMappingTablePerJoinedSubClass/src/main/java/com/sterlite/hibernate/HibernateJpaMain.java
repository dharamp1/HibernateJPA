package com.sterlite.hibernate;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sterlite.hibernate.entites.emp.Employee;
import com.sterlite.hibernate.entites.emp.mgr.Manager;
import com.sterlite.hibernate.repos.emps.EmployeeRepository;
import com.sterlite.hibernate.repos.mgrs.ManagerRepository;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 1st Sep 2020
 */
@Component
public class HibernateJpaMain implements CommandLineRunner {

	@Autowired
	EmployeeRepository empRepo;
	@Autowired
	ManagerRepository mgrRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee e1 = new Employee();
		e1.setName("Rahul Kumar");
		e1.setSalary(BigDecimal.valueOf(23000.00));
		empRepo.save(e1);
		
		Manager m1 = new Manager();
		m1.setName("Neelam Mehra");
		m1.setSalary(BigDecimal.valueOf(65000.00));
		m1.setIncentives(BigDecimal.valueOf(3000.00));
		mgrRepo.save(m1);
	}

}
