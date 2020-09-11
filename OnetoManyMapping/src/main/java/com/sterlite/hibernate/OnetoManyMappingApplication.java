package com.sterlite.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sterlite.hibernate.entities.Country;
import com.sterlite.hibernate.entities.State;
import com.sterlite.hibernate.repos.CountryRepository;
import com.sterlite.hibernate.repos.StateRepository;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 2nd Sep 2020
 */
@SpringBootApplication
public class OnetoManyMappingApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(OnetoManyMappingApplication.class);
	
	@Autowired
	private CountryRepository counRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(OnetoManyMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		State state1 = new State(1001, "Gujarat");
		State state2 = new State(1002, "Maharashtra");
		
		List<State> states = new ArrayList<>();
		states.add(state1);
		states.add(state2);
		
		Country country1 = new Country(101, "India", "Hindi", BigDecimal.valueOf(1_380_000_000));
		country1.setStates(states);
		
	//	state1.setCountry(country1);
	//	state2.setCountry(country1);
		
		
		state1 = stateRepo.save(state1);
		LOGGER.info("New state with id " + state1.getStateId() + " is saved");
		
		state2 = stateRepo.save(state2);
		LOGGER.info("New state with id " + state2.getStateId() + " is saved");
		
		country1 = counRepo.save(country1);
		LOGGER.info("New country with id " + country1.getId() + " is saved");
	
	}

}
