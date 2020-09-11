package com.sterlite.hibernate.repos.emps;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sterlite.hibernate.entites.emp.Employee;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 1st Sep 2020
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
