package com.sterlite.hibernate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.IfPointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sterlite.hibernate.entities.Country;
import com.sterlite.hibernate.entities.Flag;
import com.sterlite.hibernate.repos.CountryRepository;
import com.sterlite.hibernate.repos.FlagRepository;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 2nd Sep 2020
 */
@Component
public class HibernateMain implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateMain.class);
	
	@Autowired
	private CountryRepository counRepo;
	@Autowired
	private FlagRepository flagRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// Insert Country and it's Flag
		Country country1 = new Country(101, "India", "Hindi",BigInteger.valueOf(1_380_000_000));
			
		Flag flag1 = new Flag(11, "Horizontal tricolor of deep saffron (kesari) at the top, white in the middle and dark green at the bottom in equal proportion.In the centre of the white band is a navy blue wheel which represents the chakra.");
		
		flag1.setCountry(country1); // attaching country to flag
		country1.setFlag(flag1); // bidirectional relationship
		
		flag1 = flagRepo.save(flag1);
		LOGGER.info("New Flag with id " + flag1.getFlagId() + " saved successfully");
		
		country1 = counRepo.save(country1);
		LOGGER.info("New Country with id " + country1.getId() + " saved successfully");
	
		
		Country country2 = new Country(102, "US", "English",BigInteger.valueOf(309_000_000));
		
		Flag flag2 = new Flag(12, "The stripes represent the original 13 Colonies and the stars represent the 50 states of the Union. The colors of the flag are symbolic as well.");
		
		flag2.setCountry(country2); // attaching country to flag
		country2.setFlag(flag2); // bidirectional relationship
		
		flag2 = flagRepo.save(flag2);
		LOGGER.info("New Flag with id " + flag2.getFlagId() + " saved successfully");
		
		country2 = counRepo.save(country2);
		LOGGER.info("New Country with id " + country2.getId() + " saved successfully");
	
	}

}
