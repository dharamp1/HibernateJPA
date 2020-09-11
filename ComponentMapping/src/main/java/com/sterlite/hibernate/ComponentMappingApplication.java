package com.sterlite.hibernate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sterlite.hibernate.entities.Name;
import com.sterlite.hibernate.entities.Person;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 1st Sep 2020
 */
@SpringBootApplication
public class ComponentMappingApplication implements CommandLineRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ComponentMappingApplication.class);
	
	@Autowired
	PersonRepository personRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ComponentMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// Add New Person
		Name name = new Name("Rohan", "Madanlal", "Mehta");
		Person person = new Person();
		person.setId(BigInteger.valueOf(124567423421L));
		person.setName(name);
		person.setAge(BigDecimal.valueOf(20.7));
		person.setBirthDate(LocalDate.of(2000, 1, 12));
		
		person = personRepo.save(person);
		LOGGER.info("New person record with id " + person.getId() + " saved successfully!");
		
		// Get Person By Id
		Optional<Person> personOptional = personRepo.findById(BigInteger.valueOf(124567423421L));
		if(personOptional.isPresent()) {
			person = personOptional.get();
			LOGGER.info("Person Id: " + person.getId());
			LOGGER.info("Person Name: " + person.getName());
			LOGGER.info("Person Age: " + person.getAge());
			LocalDate birthDate = person.getBirthDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			LOGGER.info("Person BirthDate: " + birthDate.format(formatter) );
		}
	}

}
