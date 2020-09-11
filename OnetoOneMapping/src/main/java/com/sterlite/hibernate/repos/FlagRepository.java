package com.sterlite.hibernate.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sterlite.hibernate.entities.Flag;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 2nd Sep 2020
 */
public interface FlagRepository extends JpaRepository<Flag, Integer> {

}
