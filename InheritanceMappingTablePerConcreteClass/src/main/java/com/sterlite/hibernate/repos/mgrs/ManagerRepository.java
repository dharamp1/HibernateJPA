package com.sterlite.hibernate.repos.mgrs;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sterlite.hibernate.entites.emp.mgr.Manager;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 1st Sep 2020
 */
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

}
