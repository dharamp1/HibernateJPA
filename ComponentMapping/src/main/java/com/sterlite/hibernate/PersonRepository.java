package com.sterlite.hibernate;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sterlite.hibernate.entities.Person;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 1st Sep 2020
 */
public interface PersonRepository extends JpaRepository<Person, BigInteger> {

}
