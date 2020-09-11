package com.sterlite.hibernate.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sterlite.hibernate.entities.Country;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 2nd Sep 2020
 */
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
